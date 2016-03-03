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
import com.parkinglot.service.impl.AdminInfoServiceImpl;
import com.parkinglot.utils.StringUtils;

/**
 * @category 查找所有车位信息
 * @author fengyifei
 *
 */
public class GetParkinglotInfoCL extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4070133510701401068L;

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
		out.write(AdminInfoServiceImpl.getParkinglotInfo());
		// 关闭流
		out.flush();
		out.close();
	}
}
