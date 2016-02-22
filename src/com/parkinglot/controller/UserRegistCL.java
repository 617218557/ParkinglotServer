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
 * @category 用户注册的接口
 * @author fengyifei
 *
 */
public class UserRegistCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3862229147005699216L;

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
			String user_name = req.getParameter("user_name");
			String user_phoneNum = req.getParameter("user_phoneNum");
			String user_password = req.getParameter("user_password");
			int user_age = Integer.parseInt(req.getParameter("user_age"));
			int user_gender = Integer.parseInt(req.getParameter("user_gender"));
			String user_img = req.getParameter("user_img");
			// 注册并获取结果
			resultInfoBean = UserInfoServiceImpl.userRegist(user_name,
					user_phoneNum, user_password, user_age, user_gender,
					user_img);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(GlobalDefine.REGIST_FAIL,
					"注册失败,信息填写不完整");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}
}
