package com.parkinglot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parkinglot.service.impl.AdminInfoServiceImpl;

/**
 * @category 查找所有用户信息
 * @author fengyifei
 *
 */
public class GetAllUserInfoCL extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8957375192719398654L;

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
		// 返回结果
		out.write(AdminInfoServiceImpl.getAllUser());
		// 关闭流
		out.flush();
		out.close();
	}
}
