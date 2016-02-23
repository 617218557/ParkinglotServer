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
import com.parkinglot.service.impl.ParkingRecordServiceImpl;
import com.parkinglot.utils.StringUtils;

public class FindParkingRecordByCarIdCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204249453013784921L;

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
			resultInfoBean = ParkingRecordServiceImpl
					.findRecordByCarId(car_id);
		} catch (Exception e) {
			// TODO: handle exception
			resultInfoBean = new ResultInfoBean(
					GlobalDefine.RECORD_FIND_CAR_FAIL, "未查找到该车辆的停车记录信息");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}

}
