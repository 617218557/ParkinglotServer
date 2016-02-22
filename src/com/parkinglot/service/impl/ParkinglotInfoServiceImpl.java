package com.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.bean.CarInfoBean;
import com.parkinglot.bean.ParkinglotInfoBean;
import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.AddInfoDao;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.SelectInfoDao;
import com.parkinglot.dao.impl.UpdateInfoDao;
import com.parkinglot.utils.TimeUtils;

/**
 * @category 停车场相关逻辑处理
 * @author fengyifei
 *
 */
public class ParkinglotInfoServiceImpl {

	/**
	 * @category 查找所有可用车位
	 * @return
	 */
	public static ResultInfoBean findAllParkingSpace() {
		List<ParkinglotInfoBean> list = new ArrayList<ParkinglotInfoBean>();
		ResultInfoBean resultInfoBean;
		list = SelectInfoDao.selectParkinglotInfo();
		if (list.size() == 0) {
			// 无可用车位
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.PARK_FIND_NO_NOT_USED, "暂无可用车位");
		} else {
			// 有可用车位
			resultInfoBean = new ResultInfoBean(list);
		}
		return resultInfoBean;
	}

	/**
	 * @category 寻找未被占用的车位
	 * @return
	 */
	public static ResultInfoBean findNotUsedParkingSpace() {
		List<ParkinglotInfoBean> list = new ArrayList<ParkinglotInfoBean>();
		ResultInfoBean resultInfoBean;
		list = SelectInfoDao.selectParkinglotInfo(CreateWordDao.PARK_ISUSE,
				GlobalDefine.PARK_NOT_USED + "");
		if (list.size() == 0) {
			// 无可用车位
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.PARK_FIND_NO_NOT_USED, "暂无可用车位");
		} else {
			// 有可用车位
			resultInfoBean = new ResultInfoBean(list);
		}
		return resultInfoBean;
	}

	/**
	 * @category 按id寻找车位
	 * @param park_id
	 *            车位Id
	 */
	private static ParkinglotInfoBean findParkinglotById(int park_id) {
		return SelectInfoDao.selectParkinglotInfo(CreateWordDao.PARK_ID,
				park_id + "").get(0);
	}

	/**
	 * @category 根据用户id查询用户今日的预约
	 * @param user_id
	 * @return
	 */
	public static ResultInfoBean findTodayOrderByUserId(int user_id) {
		List<CarInfoBean> carList = SelectInfoDao.selectCarInfo(
				CreateWordDao.USER_ID, user_id + "");
		List<ParkinglotInfoBean> parkList = SelectInfoDao.selectParkinglotInfo(
				CreateWordDao.PARK_ISUSE, GlobalDefine.PARK_USED + "");
		List<ParkinglotInfoBean> resultList = new ArrayList<ParkinglotInfoBean>();
		for (ParkinglotInfoBean bean : parkList) {
			for (CarInfoBean car : carList) {
				if (bean.getPark_car().equals(car.getCar_id()+"")) {
					resultList.add(bean);
					continue;
				}
			}
		}
		ResultInfoBean resultInfoBean;
		if (resultList.size() == 0) {
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.PARK_NOT_HAVE_ORDER, "今日无预约");
		} else {
			resultInfoBean = new ResultInfoBean(resultList);
		}
		return resultInfoBean;
	}

	/**
	 * @category 预约车位
	 * @param park_id
	 *            车位id
	 * @param car_id
	 *            车辆id
	 * @param park_startTime
	 *            预约时间
	 * @return ResultInfoBean 预约结果
	 */
	public static ResultInfoBean orderParkingSpace(int park_id, int car_id,
			String park_startTime) {
		ParkinglotInfoBean parkinglotInfoBean = findParkinglotById(park_id);
		ResultInfoBean resultInfoBean;
		if (parkinglotInfoBean.getPark_isUse() == GlobalDefine.PARK_USED) {
			// 车位已被占用
			resultInfoBean = new ResultInfoBean(GlobalDefine.PARK_ORDER_USED,
					"车位已被占用");
		} else {
			// 检查预约时间合法性
			if (TimeUtils.comparePointTime(park_startTime)) {
				// 在当前时间之后 可以预约车位
				// 检查车辆是否已经预约
				if(SelectInfoDao.selectParkinglotInfo(CreateWordDao.PARK_CAR, car_id+"").size()==0){
					//车辆可预约 
					if (UpdateInfoDao.updateParkingLotInfo(park_id,
							GlobalDefine.PARK_FEE, GlobalDefine.PARK_USED, car_id,
							park_startTime)) {
						resultInfoBean = new ResultInfoBean("预约成功");
					} else {
						resultInfoBean = new ResultInfoBean(
								GlobalDefine.PARK_ORDER_FAIL, "预约失败");
					}
				}else{
					// 该车已经预约
					resultInfoBean = new ResultInfoBean(
							GlobalDefine.PARK_ORDER_CAR_ORDERED, "该车辆已经有预约");
				}
			} else {
				// 在当前时间之前 不可预约车位
				resultInfoBean = new ResultInfoBean(
						GlobalDefine.PARK_ORDER_TIME_NOT_LEGEL, "预约时间不合法");
			}

		}
		return resultInfoBean;
	}

	/**
	 * @category 车辆停靠结束
	 * @param park_id
	 */
	public static ResultInfoBean endOrderParkingSpace(int park_id) {
		ResultInfoBean resultInfoBean;
		ParkinglotInfoBean parkinglotInfoBean = SelectInfoDao
				.selectParkinglotInfo(CreateWordDao.PARK_ID, park_id + "").get(
						0);
		String startTime = parkinglotInfoBean.getPark_startTime(); // 开始时间
		String endTime = TimeUtils.getCurrentTime();// 结束时间
		double fee = 0.0;// 停车费用
		// 计算停车费用
		int hour = TimeUtils.getTimeDifference(startTime, endTime);
		fee = parkinglotInfoBean.getPark_fee() * hour;
		// 写入停车记录表
		AddInfoDao.addParkingRecordInfo(
				Integer.parseInt(parkinglotInfoBean.getPark_car()), startTime,
				endTime, fee);
		// 停止停靠
		UpdateInfoDao.updateParkingLotInfo(park_id, GlobalDefine.PARK_FEE,
				GlobalDefine.PARK_NOT_USED, 0, "");
		resultInfoBean = new ResultInfoBean("车辆停靠结束");
		return resultInfoBean;
	}

	/**
	 * @category 取消预约车位
	 * @param park_id
	 */
	public static ResultInfoBean cancleOrderParkingSpace(int park_id) {
		ResultInfoBean resultInfoBean;
		if (UpdateInfoDao.updateParkingLotInfo(park_id, GlobalDefine.PARK_FEE,
				GlobalDefine.PARK_NOT_USED, 0, "")) {
			// 取消成功
			resultInfoBean = new ResultInfoBean("取消成功");
		} else {
			// 取消失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.PARK_CANCLE_FAIL,
					"取消失败");
		}
		return resultInfoBean;
	}

	/**
	 * @category 清空停车场信息
	 */
	public static void clearParkinglot() {
		List<ParkinglotInfoBean> list = SelectInfoDao.selectParkinglotInfo();
		for(ParkinglotInfoBean bean:list){
			if(bean.getPark_isUse() == GlobalDefine.PARK_USED){
				// 如果车位被占用，则自动结束停车
				endOrderParkingSpace(bean.getPark_id());
			}
			UpdateInfoDao.updateParkingLotInfo(bean.getPark_id(), GlobalDefine.PARK_FEE,
					GlobalDefine.PARK_NOT_USED, 0, "");
		}
	}
}
