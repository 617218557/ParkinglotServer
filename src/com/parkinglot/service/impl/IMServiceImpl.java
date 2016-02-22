package com.parkinglot.service.impl;

import java.util.List;

import com.parkinglot.bean.IMInfoBean;
import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.dao.impl.AddInfoDao;
import com.parkinglot.dao.impl.CreateWordDao;
import com.parkinglot.dao.impl.SelectInfoDao;
import com.parkinglot.utils.StringUtils;

public class IMServiceImpl {

	// 根据手机号查找即时通信的登录账号和密码，若不存在则创建一个
	public static ResultInfoBean getIMInfoByPhoneNum(int user_id,
			String im_account) {
		ResultInfoBean resultInfoBean;
		List<IMInfoBean> imList = SelectInfoDao.selectIMInfo(
				CreateWordDao.IM_ACCOUNT, im_account);
		if (imList.size() == 0) {
			// 用户不存在时
			String im_password = StringUtils.genRandomNum(15);// 生成15位随机密码
			AddInfoDao.addIMInfo(user_id, im_account, im_password);
			resultInfoBean = new ResultInfoBean(GlobalDefine.IM_NOT_REGIST,
					SelectInfoDao.selectIMInfo(CreateWordDao.IM_ACCOUNT,
							im_account).get(0));
		} else {
			resultInfoBean = new ResultInfoBean(imList.get(0));
		}
		return resultInfoBean;
	}

}
