package com.parkinglot.dao.impl;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (CreateWordDao.createAllTable()) {
			System.out.println("creat sql success");// 创建数据库成功
		} else {
			System.out.println("creat sql failure");// 创建数据库失败
			return;
		}
	}

}
