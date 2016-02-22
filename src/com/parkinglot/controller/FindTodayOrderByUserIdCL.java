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
import com.parkinglot.service.impl.ParkinglotInfoServiceImpl;
import com.parkinglot.utils.StringUtils;

public class FindTodayOrderByUserIdCL extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -126915462031571902L;

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
			resultInfoBean = ParkinglotInfoServiceImpl
					.findTodayOrderByUserId(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(GlobalDefine.PARK_HAVE_ORDER_FAIL,
					"未查找到该用户的预约信息");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}
}
