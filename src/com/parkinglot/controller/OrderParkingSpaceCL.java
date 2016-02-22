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

/**
 * @category 预约车位的接口
 * @author fengyifei
 *
 */
public class OrderParkingSpaceCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4418798466883509218L;

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
			int park_id = Integer.parseInt(req.getParameter("park_id"));
			int car_id = Integer.parseInt(req.getParameter("car_id"));
			String park_startTime = req.getParameter("park_startTime");

			resultInfoBean = ParkinglotInfoServiceImpl.orderParkingSpace(park_id,
					car_id, park_startTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultInfoBean = new ResultInfoBean(GlobalDefine.PARK_ORDER_FAIL,
					"预约失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}

}
