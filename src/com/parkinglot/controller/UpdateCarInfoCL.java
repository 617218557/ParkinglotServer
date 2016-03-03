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
import com.parkinglot.service.impl.CarInfoServiceImpl;
import com.parkinglot.utils.StringUtils;

public class UpdateCarInfoCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104775503396296506L;

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
			int car_id = Integer.parseInt(req.getParameter("car_id"));
			String car_licenseNum = req.getParameter("car_licenseNum");
			String car_type = req.getParameter("car_type");
			String car_img = req.getParameter("car_img");

			// 判断是否从前端传来，需要进行base64编码，和客户端统一
			String from = req.getParameter("oper");
			if (from != null && from.equals("edit")) {
				car_licenseNum = StringUtils.Base64Encode(car_licenseNum);
				car_type = StringUtils.Base64Encode(car_type);
			}

			resultInfoBean = CarInfoServiceImpl.updateCarInfo(car_id,
					car_licenseNum, car_type, car_img);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(GlobalDefine.CAR_ADD_FAIl,
					"修改失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}
}
