package com.parkinglot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.parkinglot.bean.ResultInfoBean;
import com.parkinglot.common.GlobalDefine;
import com.parkinglot.service.impl.CarInfoServiceImpl;
import com.parkinglot.service.impl.UserInfoServiceImpl;
import com.parkinglot.utils.StringUtils;

/**
 * @category 修改用户信息
 * @author fengyifei
 *
 */
public class UpdateUserInfoCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7900754679999033400L;

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
			String user_name = req.getParameter("user_name");
			int user_age = Integer.parseInt(req.getParameter("user_age"));
			int user_gender = Integer.parseInt(req.getParameter("user_gender"));
			System.out.println(user_name + "@!!!");
			resultInfoBean = UserInfoServiceImpl.updateUserInfo(user_id,
					user_name, user_gender, user_age);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.UPDATE_USER_INFO_FAIL, "修改失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}

}
