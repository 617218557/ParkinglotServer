package com.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.bean.AdminInfoBean;
import com.parkinglot.bean.CarInfoBean;
import com.parkinglot.bean.GridInfoBean;
import com.parkinglot.bean.ParkinglotInfoBean;
import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.bean.UserInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.SelectInfoDao;

public class AdminInfoServiceImpl {

	/**
	 * @category 管理员登录，返回值 用户不存在-2 密码错误-3
	 * @param user_phoneNum
	 * @param user_password
	 * @return
	 */
	public static ResultInfoBean adminLogin(String admin_user,
			String admin_password) {
		AdminInfoBean adminInfoBean = findAdminIsExist(admin_user);
		ResultInfoBean resultInfoBean;
		// 用户不存在
		if (adminInfoBean == null) {
			resultInfoBean = new ResultInfoBean(GlobalDefine.LOGIN_NOT_EXIST,
					"用户不存在");
		} else {
			if (adminInfoBean.getAdmin_password().equals(admin_password)) {
				// 用户名密码验证成功
				resultInfoBean = new ResultInfoBean(adminInfoBean);
			} else {
				// 密码错误
				resultInfoBean = new ResultInfoBean(
						GlobalDefine.LOGIN_PASSWORD_ERROR, "密码错误");
			}
		}
		return resultInfoBean;
	}

	/**
	 * @category 查找管理员是否存在
	 * @param phoneNum
	 * @return
	 */
	private static AdminInfoBean findAdminIsExist(String admin_user) {
		List<AdminInfoBean> list = new ArrayList<AdminInfoBean>();
		list = SelectInfoDao.selectAdminInfo(CreateWordDao.ADMIN_USER,
				admin_user);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;

	}

	/**
	 * @category 查找所有用户
	 * @param phoneNum
	 * @return
	 */
	public static String getAllUser() {
		List<UserInfoBean> userInfoList = new ArrayList<UserInfoBean>();
		userInfoList = SelectInfoDao.selectAllUserInfo();
		return new GridInfoBean().getUserGridInfo(userInfoList);
	}

	/**
	 * @category 查找所有车位
	 * @param phoneNum
	 * @return
	 */
	public static String getParkinglotInfo() {
		List<ParkinglotInfoBean> parkinglotInfoList = new ArrayList<ParkinglotInfoBean>();
		parkinglotInfoList = SelectInfoDao.selectParkinglotInfo();
		return new GridInfoBean().getParkinglotGridInfo(parkinglotInfoList);
	}

	/**
	 * @category 查找所有车辆
	 * @param phoneNum
	 * @return
	 */
	public static String getAllCarInfo() {
		List<CarInfoBean> carInfoList = new ArrayList<CarInfoBean>();
		carInfoList = SelectInfoDao.selectAllCarInfo();
		return new GridInfoBean().getCarGridInfo(carInfoList);
	}

}
