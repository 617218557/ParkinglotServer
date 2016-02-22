package com.parkinglot.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @category 连接数据库
 * @author fengyifei
 *
 */
public class CreateTableDao {
	private static String username = "root";
	private static String password = "root";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/parkinglot";

	static Connection conn = null;
	static java.sql.Statement st = null;
	static String className = "com.parkinglot.dao.impl.PublicInfoDao";
	static PublicInfoDao info = null;

	public static boolean createTable(String createWord, String tableName) {
		boolean flag = false;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String haveForeign = "show databases like \'" + tableName + "\'";
			st.executeUpdate(haveForeign);
			String set = "set foreign_key_checks=0;";
			st.executeUpdate(set);
			String checkTable = "drop table if exists " + tableName + ";";
			st.executeUpdate(checkTable);
			st.executeUpdate(createWord);
			String seted = "set foreign_key_checks=1;";
			st.executeUpdate(seted);
			flag = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}
