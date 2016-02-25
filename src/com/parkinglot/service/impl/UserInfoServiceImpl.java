package com.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.bean.UserInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.AddInfoDao;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.SelectInfoDao;
import com.parkinglot.dao.impl.UpdateInfoDao;

/**
 * @category 用户信息相关处理
 * @author fengyifei
 *
 */
public class UserInfoServiceImpl {

	/**
	 * 用户注册的逻辑处理
	 * 
	 * @param user_name
	 * @param user_phoneNum
	 * @param user_password
	 * @param user_age
	 * @param user_gender
	 * @param user_img
	 * @return 注册成功返回用户，注册失败返回-1，用户已存在返回-2
	 */
	public static ResultInfoBean userRegist(String user_name,
			String user_phoneNum, String user_password, int user_age,
			int user_gender, String user_img) {
		ResultInfoBean resultInfoBean;
		if (findUserIsExist(user_phoneNum) != null) {
			// 用户已存在
			resultInfoBean = new ResultInfoBean(GlobalDefine.REGIST_EXIST,
					"用户已存在");
		} else {
			if (AddInfoDao.addUserInfo(user_name, user_phoneNum, user_password,
					user_age, user_gender, user_img)) {
				// 注册成功
				resultInfoBean = new ResultInfoBean(
						findUserIsExist(user_phoneNum));
			} else {
				// 注册失败
				resultInfoBean = new ResultInfoBean(GlobalDefine.REGIST_FAIL,
						"注册失败");
			}
		}
		return resultInfoBean;
	}

	/**
	 * @category 用户登录，返回值 用户不存在-2 密码错误-3
	 * @param user_phoneNum
	 * @param user_password
	 * @return
	 */
	public static ResultInfoBean userLogin(String user_phoneNum,
			String user_password) {
		UserInfoBean userInfoBean = findUserIsExist(user_phoneNum);
		ResultInfoBean resultInfoBean;
		// 用户不存在
		if (userInfoBean == null) {
			resultInfoBean = new ResultInfoBean(GlobalDefine.LOGIN_NOT_EXIST,
					"用户不存在");
		} else {
			if (userInfoBean.getUser_password().equals(user_password)) {
				// 用户名密码验证成功
				resultInfoBean = new ResultInfoBean(userInfoBean);
			} else {
				// 密码错误
				resultInfoBean = new ResultInfoBean(
						GlobalDefine.LOGIN_PASSWORD_ERROR, "密码错误");
			}
		}
		return resultInfoBean;
	}

	/**
	 * @category 查找用户是否存在
	 * @param phoneNum
	 * @return
	 */
	public static UserInfoBean findUserIsExist(String user_phoneNum) {
		List<UserInfoBean> list = new ArrayList<UserInfoBean>();
		list = SelectInfoDao.selectUserInfo(CreateWordDao.USER_PHONENUM,
				user_phoneNum);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * @category 修改用户信息
	 * @param user_id
	 * @param user_phoneNum
	 * @param user_gender
	 * @param user_age
	 */
	public static ResultInfoBean updateUserInfo(int user_id, String user_name,
			int user_gender, int user_age) {
		ResultInfoBean resultInfoBean;
		UserInfoBean userInfoBean = SelectInfoDao.selectUserInfo(
				CreateWordDao.USER_ID, user_id + "").get(0);
		if (UpdateInfoDao.updateUserInfo(user_id, user_name,
				userInfoBean.getUser_phoneNum(),
				userInfoBean.getUser_password(), user_age, user_gender,
				userInfoBean.getUser_img())) {
			resultInfoBean = new ResultInfoBean(SelectInfoDao.selectUserInfo(
					CreateWordDao.USER_ID, user_id + "").get(0));
		} else {
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.UPDATE_USER_INFO_FAIL, "修改失败");
		}
		return resultInfoBean;
	}

	
	/**
	 * @category 修改用户密码
	 * @param user_id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	public static ResultInfoBean updateUserPassword(int user_id,
			String old_password, String new_password) {
		ResultInfoBean resultInfoBean;
		UserInfoBean userInfoBean = SelectInfoDao.selectUserInfo(
				CreateWordDao.USER_ID, user_id + "").get(0);
		if (userInfoBean.getUser_password().equals(old_password)) {
			if (UpdateInfoDao.updateUserInfo(user_id,
					userInfoBean.getUser_name(),
					userInfoBean.getUser_phoneNum(), new_password,
					userInfoBean.getUser_age(), userInfoBean.getUser_gender(),
					userInfoBean.getUser_img())) {
				resultInfoBean = new ResultInfoBean("修改成功");
			} else {
				resultInfoBean = new ResultInfoBean(
						GlobalDefine.UPDATE_USER_INFO_FAIL, "修改失败");
			}
		} else {
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.UPDATE_USER_PASSWORD_ERROR, "旧密码错误");
		}
		return resultInfoBean;
	}
}
