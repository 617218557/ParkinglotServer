package com.parkinglot.bean;

/**
 * @category 用于向客户端返回信息的模型
 * @author fengyifei
 *
 */
public class ResultInfoBean {

	private int code; // 错误码
	private Object msg; // 信息

	// 构造方法
	public ResultInfoBean() {

	}

	public ResultInfoBean(int code, Object msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @category 成功时的构造方法
	 * @param msg
	 */
	public ResultInfoBean(Object msg) {
		code = 1;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResultInfoBean [code=" + code + ", msg=" + msg + "]";
	}

}
