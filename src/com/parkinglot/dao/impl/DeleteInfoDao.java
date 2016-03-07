package com.parkinglot.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @category 删除数据库中信息
 * @author fengyifei
 *
 */
public class DeleteInfoDao {

	static Connection conn = null;
	static java.sql.PreparedStatement ps = null;
	static ResultSet rs = null;
	static String className = "com.parkinglot.dao.impl.PublicInfoDao";
	static PublicInfoDao info = null;
	static String sql = null;
	
	/**
	 * @category删除用户 
	 * @param user_id
	 * @return
	 */
	public static boolean deleteUser(int user_id){
		boolean flag = false;
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "delete from " + CreateWordDao.USER_TABLE_NAME + " where "
					+ CreateWordDao.USER_ID + "=" + user_id + ";";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			info.free(conn, ps, rs);
		}
		return flag;	
	}

	/**
	 * @category 删除车辆信息
	 * @param car_id
	 * @return
	 */
	public static boolean deleteCarInfo(int car_id) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "delete from " + CreateWordDao.CAR_TABLE_NAME + " where "
					+ CreateWordDao.CAR_ID + "=" + car_id + ";";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			info.free(conn, ps, rs);
		}
		return flag;
	}
	
}
