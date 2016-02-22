package com.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.bean.CarInfoBean;
import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.AddInfoDao;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.DeleteInfoDao;
import com.parkinglot.dao.impl.SelectInfoDao;
import com.parkinglot.dao.impl.UpdateInfoDao;

public class CarInfoServiceImpl {

	/**
	 * @category 根据用户ID查找车辆信息
	 * @param UserId
	 * @return
	 */
	public static ResultInfoBean findCarInfoByUserId(int UserId) {
		List<CarInfoBean> list = new ArrayList<CarInfoBean>();
		ResultInfoBean resultInfoBean;
		list = SelectInfoDao.selectCarInfo(CreateWordDao.USER_ID, UserId + "");
		if (list.size() > 0) {
			// 查询成功
			resultInfoBean = new ResultInfoBean(list);
		} else {
			// 查询失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.CAR_FIND_FAIL,
					"未查找到该用户的车辆信息");
		}
		return resultInfoBean;
	}

	/**
	 * @category 添加车辆信息
	 * @param car_licenseNum
	 * @param user_id
	 * @param car_type
	 * @param car_img
	 * @return
	 */
	public static ResultInfoBean addCarInfo(String car_licenseNum, int user_id,
			String car_type, String car_img) {
		ResultInfoBean resultInfoBean;
		if (AddInfoDao.addCarInfo(car_licenseNum, user_id, car_type, car_img)) {
			// 添加成功
			resultInfoBean = new ResultInfoBean("添加成功");
		} else {
			// 添加失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.CAR_ADD_FAIl,
					"添加失败");
		}
		return resultInfoBean;
	}

	/**
	 * @category 更改车辆信息
	 * @param car_id
	 * @param car_licenseNum
	 * @param car_type
	 * @param car_img
	 * @return
	 */
	public static ResultInfoBean updateCarInfo(int car_id,
			String car_licenseNum, String car_type, String car_img) {
		ResultInfoBean resultInfoBean;
		CarInfoBean carInfoBean = SelectInfoDao.selectCarInfo(
				CreateWordDao.CAR_ID, car_id + "").get(0);
		if (UpdateInfoDao.updateCarInfo(car_id, car_licenseNum,
				carInfoBean.getUser_id(), car_type, car_img)) {
			// 更改成功
			resultInfoBean = new ResultInfoBean("修改成功");
		} else {
			// 更改失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.CAR_UPDATE_FAIL,
					"修改失败");
		}
		return resultInfoBean;
	}

	/**
	 * @category 删除车辆信息
	 * @param car_id
	 * @return
	 */
	public static ResultInfoBean deleteCarInfo(int car_id) {
		ResultInfoBean resultInfoBean;
		if (DeleteInfoDao.deleteCarInfo(car_id)) {
			// 更改成功
			resultInfoBean = new ResultInfoBean("删除成功");
		} else {
			// 更改失败
			resultInfoBean = new ResultInfoBean(GlobalDefine.CAR_DELETE_FAIL,
					"删除失败");
		}
		return resultInfoBean;
	}
}
