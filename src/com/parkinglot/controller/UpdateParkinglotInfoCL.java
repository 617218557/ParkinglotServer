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

public class UpdateParkinglotInfoCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7104869833503178098L;

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
			int park_id = Integer.parseInt(req.getParameter("park_id"));
			double park_fee = Double.parseDouble(req.getParameter("park_fee"));
			int park_isUse = Integer.parseInt(req.getParameter("park_isUse"));
			int park_car = Integer.parseInt(req.getParameter("park_car"));
			String park_startTime = req.getParameter("park_startTime");

			// 判断是否从前端传来，需要base64编码，和客户端统一
			String from = req.getParameter("oper");
			if (from != null && from.equals("edit")) {

			}

			resultInfoBean = ParkinglotInfoServiceImpl.updateParkinglot(
					park_id, park_fee, park_isUse, park_car, park_startTime);
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
