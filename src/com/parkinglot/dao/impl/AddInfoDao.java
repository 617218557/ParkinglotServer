package com.parkinglot.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author fengyifei
 * @category 向数据库中添加信息
 */
public class AddInfoDao {
	static Connection conn = null;
	static java.sql.PreparedStatement ps = null;
	static ResultSet rs = null;
	static String className = "com.parkinglot.dao.impl.PublicInfoDao";
	static PublicInfoDao info = null;
	static String sql = null;

	/**
	 * @category 添加用户
	 * @param user_name
	 * @param user_phoneNum
	 * @param user_password
	 * @param user_age
	 * @param user_gender
	 * @param user_img
	 * @return
	 */
	public static boolean addUserInfo(String user_name, String user_phoneNum,
			String user_password, int user_age, int user_gender, String user_img) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.USER_TABLE_NAME + "("
					+ CreateWordDao.USER_NAME + "," + ""
					+ CreateWordDao.USER_PHONENUM + ","
					+ CreateWordDao.USER_PASSWORD + ","
					+ CreateWordDao.USER_AGE + "," + CreateWordDao.USER_GENDER
					+ "," + CreateWordDao.USER_IMG + ") values(?,?,?,?,?,?);";

			ps = conn.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, user_phoneNum);
			ps.setString(3, user_password);
			ps.setInt(4, user_age);
			ps.setInt(5, user_gender);
			ps.setString(6, user_img);
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
	 * @category 添加车辆信息
	 * @param car_licenseNum
	 * @param user_id
	 * @param car_type
	 * @return
	 */
	public static boolean addCarInfo(String car_licenseNum, int user_id,
			String car_type, String car_img) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.CAR_TABLE_NAME + "("
					+ CreateWordDao.CAR_LICENSENUM + "," + ""
					+ CreateWordDao.USER_ID + "," + CreateWordDao.CAR_TYPE
					+ "," + CreateWordDao.CAR_IMG + ") values(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, car_licenseNum);
			ps.setInt(2, user_id);
			ps.setString(3, car_type);
			ps.setString(4, car_img);
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
	 * @category 添加停车场车位信息
	 * @param park_fee
	 * @param park_isUse
	 * @param park_car
	 * @param park_startTime
	 * @return
	 */
	public static boolean addParkingLotInfo(double park_fee, int park_isUse,
			int park_car, String park_startTime) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.PARKINGLOT_TABLE_NAME + "("
					+ CreateWordDao.PARK_FEE + "," + CreateWordDao.PARK_ISUSE
					+ "," + CreateWordDao.PARK_CAR + ","
					+ CreateWordDao.PARK_STARTTIME + "" + ") values(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, park_fee);
			ps.setInt(2, park_isUse);
			ps.setInt(3, park_car);
			ps.setString(4, park_startTime);
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
	 * @category 添加停车记录信息
	 * @param car_id
	 * @param record_strartTime
	 * @param record_endTime
	 * @param record_fee
	 * @return
	 */
	public static boolean addParkingRecordInfo(int car_id,
			String record_strartTime, String record_endTime, double record_fee) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.PARKINGRECORD_TABLE_NAME + "("
					+ CreateWordDao.CAR_ID + ","
					+ CreateWordDao.RECORD_STARTTIME + ","
					+ CreateWordDao.RECORD_ENDTIME + ","
					+ CreateWordDao.RECORD_FEE + ") values(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car_id);
			ps.setString(2, record_strartTime);
			ps.setString(3, record_endTime);
			ps.setDouble(4, record_fee);
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
	 * @category 添加管理员
	 * @param admin_user
	 * @param admin_password
	 * @return
	 */
	public static boolean addAdminInfo(String admin_user, String admin_password) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.ADMIN_TABLE_NAME + "("
					+ CreateWordDao.ADMIN_USER + ","
					+ CreateWordDao.ADMIN_PASSWORD + ") values(?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin_user);
			ps.setString(2, admin_password);
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
	 * @category 添加即时通信用户
	 * @param admin_user
	 * @param admin_password
	 * @return
	 */
	public static boolean addIMInfo(int user_id, String im_account,
			String im_password) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "insert into " + CreateWordDao.IM_TABLE_NAME + "("
					+ CreateWordDao.USER_ID + "," + CreateWordDao.IM_ACCOUNT
					+ "," + CreateWordDao.IM_PASSWORD + ") values(?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, im_account);
			ps.setString(3, im_password);
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
