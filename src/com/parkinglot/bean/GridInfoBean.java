package com.parkinglot.bean;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * @category 用于返回前段表格的数据
 * @author fengyifei
 *
 */
public class GridInfoBean {
	private String page;
	private String total;
	private String records;
	private ArrayList<String> rows = new ArrayList<String>();

	public String getUserGridInfo(List<UserInfoBean> infoBeanList) {
		page = "1";
		total = "1";
		records = infoBeanList.size() + "";
		int count = infoBeanList.size();
		for (int i = 0; i < count; i++) {
			rows.add(new GridCellInfoBean().getUserCellInfo(i,
					infoBeanList.get(i)));
		}
		return JSONObject.fromObject(this).toString();
	}

	public String getCarGridInfo(List<CarInfoBean> infoBeanList) {
		page = "1";
		total = "1";
		records = infoBeanList.size() + "";
		int count = infoBeanList.size();
		for (int i = 0; i < count; i++) {
			rows.add(new GridCellInfoBean().getCarCellInfo(i,
					infoBeanList.get(i)));
		}
		return JSONObject.fromObject(this).toString();
	}

	public String getParkinglotGridInfo(List<ParkinglotInfoBean> infoBeanList) {
		page = "1";
		total = "1";
		records = infoBeanList.size() + "";
		int count = infoBeanList.size();
		for (int i = 0; i < count; i++) {
			rows.add(new GridCellInfoBean().getParkinglotCellInfo(i,
					infoBeanList.get(i)));
		}
		return JSONObject.fromObject(this).toString();
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public ArrayList<String> getRows() {
		return rows;
	}

	public void setRows(ArrayList<String> rows) {
		this.rows = rows;
	}

}
