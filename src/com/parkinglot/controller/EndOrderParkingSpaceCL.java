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
 * @category 结束车辆停靠
 * @author fengyifei
 *
 */
public class EndOrderParkingSpaceCL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6388653150077787387L;

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

			resultInfoBean = ParkinglotInfoServiceImpl
					.endOrderParkingSpace(park_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultInfoBean = new ResultInfoBean(GlobalDefine.PARK_END_FAIL,
					"操作失败");
		}
		// 返回结果
		out.write(StringUtils.Base64Encode(JSONObject
				.fromObject(resultInfoBean)));
		// 关闭流
		out.flush();
		out.close();
	}
}
