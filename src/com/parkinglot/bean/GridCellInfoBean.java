package com.parkinglot.bean;

import it.sauronsoftware.base64.Base64;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * @category 返回给前端表格的每一个item的数据结构
 * @author fengyifei
 *
 */
public class GridCellInfoBean {
	private String id;
	private ArrayList<String> cell = new ArrayList<String>();

	public String getUserCellInfo(int index, UserInfoBean userInfoBean) {
		this.id = index + "";
		this.cell.add(userInfoBean.getUser_id() + "");
		try {
			this.cell.add(Base64.decode(userInfoBean.getUser_name(), "utf8"));
		} catch (Exception e) {
			this.cell.add(userInfoBean.getUser_name());
		}
		this.cell.add(userInfoBean.getUser_phoneNum());
		this.cell.add(userInfoBean.getUser_password());
		this.cell.add(userInfoBean.getUser_age() + "");
		this.cell.add(userInfoBean.getUser_gender() == 0 ? "女" : "男");
		this.cell.add(userInfoBean.getUser_img() + "");
		return JSONObject.fromObject(this).toString();
	}

	public String getCarCellInfo(int index, CarInfoBean carInfoBean) {
		this.id = index + "";
		this.cell.add(carInfoBean.getUser_id() + "");
		try {
			this.cell
					.add(Base64.decode(carInfoBean.getCar_licenseNum(), "utf8"));
		} catch (Exception e) {
			this.cell.add(carInfoBean.getCar_licenseNum());
		}
		this.cell.add(carInfoBean.getUser_id() + "");
		try {
			this.cell.add(Base64.decode(carInfoBean.getCar_type(), "utf8"));
		} catch (Exception e) {
			this.cell.add(carInfoBean.getCar_type());
		}
		this.cell.add(carInfoBean.getCar_img() + "");
		return JSONObject.fromObject(this).toString();
	}

	public String getParkinglotCellInfo(int index,
			ParkinglotInfoBean parkinglotInfoBean) {
		this.id = index + "";
		this.cell.add(parkinglotInfoBean.getPark_id() + "");
		this.cell.add(parkinglotInfoBean.getPark_fee() + "");
		this.cell.add(parkinglotInfoBean.getPark_isUse() + "");
		this.cell.add(parkinglotInfoBean.getPark_car());
		this.cell.add(parkinglotInfoBean.getPark_startTime());
		return JSONObject.fromObject(this).toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getCell() {
		return cell;
	}

	public void setCell(ArrayList<String> cell) {
		this.cell = cell;
	}

}
