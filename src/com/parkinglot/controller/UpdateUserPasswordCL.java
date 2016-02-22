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

public class UpdateUserPasswordCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7369602962195137112L;

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
			int user_id = Integer.parseInt(req.getParameter("user_id"));
			String old_password = req.getParameter("old_password");
			String new_password = req.getParameter("new_password");

			resultInfoBean = UserInfoServiceImpl.updateUserPassword(user_id,
					old_password, new_password);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.UPDATE_USER_PASSSWORD_FAIL, "修改失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}

}
