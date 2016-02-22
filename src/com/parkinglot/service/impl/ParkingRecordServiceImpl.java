package com.parkinglot.service.impl;

import java.util.List;

import com.parkinglot.bean.ParkingRecordInfoBean;
import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.SelectInfoDao;

/**
 * @category 停车记录相关逻辑
 * @author fengyifei
 *
 */
public class ParkingRecordServiceImpl {

	/**
	 * @category 根据用户id查询停车记录
	 * @param user_id
	 * @return
	 */
	public static ResultInfoBean findRecordByUserId(int user_id) {
		ResultInfoBean resultInfoBean;
		List<ParkingRecordInfoBean> list = SelectInfoDao
				.selectRecordInfoByUserId(user_id + "");
		if (list.size() > 0) {
			// 获取数据成功
			resultInfoBean = new ResultInfoBean(list);
		} else {
			// 获取数据失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.RECORD_FIND_USER_FAIL,
					"未查找到该用户的停车记录信息");
		}
		return resultInfoBean;
	}

	/**
	 * @category 根据车辆id查询停车信息
	 * @param car_id
	 * @return
	 */
	public static ResultInfoBean findRecordByCarId(int car_id) {
		ResultInfoBean resultInfoBean;
		List<ParkingRecordInfoBean> list = SelectInfoDao.selectRecordInfo(
				CreateWordDao.CAR_ID, car_id + "");
		if (list.size() > 0) {
			// 获取数据成功
			resultInfoBean = new ResultInfoBean(list);
		} else {
			// 获取数据失败
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.RECORD_FIND_CAR_FAIL, "未查找到该车辆的停车记录信息");
		}
		return resultInfoBean;
	}

}
