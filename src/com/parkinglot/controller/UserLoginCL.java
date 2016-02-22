package com.parkinglot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.service.impl.UserInfoServiceImpl;
import com.parkinglot.utils.StringUtils;

/**
 * @category 用户登陆的接口
 * @author fengyifei
 *
 */
public class UserLoginCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7919639282822066820L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 输出流
		PrintWriter out = resp.getWriter();
		ResultInfoBean resultInfoBean;
		try {
			// 获取参数
			String user_phoneNum = req.getParameter("user_phoneNum");
			String user_password = req.getParameter("user_password");
			// 登录并获取结果
			resultInfoBean = UserInfoServiceImpl.userLogin(user_phoneNum,
					user_password);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(GlobalDefine.LOGIN_FAIL, "登录失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}

}
