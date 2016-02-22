package com.parkinglot.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @category 更新表中信息
 * @author fengyifei
 *
 */
public class UpdateInfoDao {
	static Connection conn = null;
	static java.sql.PreparedStatement ps = null;
	static ResultSet rs = null;
	static String className = "com.parkinglot.dao.impl.PublicInfoDao";
	static PublicInfoDao info = null;
	static String sql = null;

	/**
	 * @category 更新用户表
	 * @param user_id
	 * @param user_name
	 * @param user_phoneNum
	 * @param user_password
	 * @param user_age
	 * @param user_gender
	 * @param user_img
	 * @return
	 */
	public static boolean updateUserInfo(int user_id, String user_name,
			String user_phoneNum, String user_password, int user_age,
			int user_gender, String user_img) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "update " + CreateWordDao.USER_TABLE_NAME + " set "
					+ CreateWordDao.USER_NAME + "=?," + ""
					+ CreateWordDao.USER_PHONENUM + "=?,"
					+ CreateWordDao.USER_PASSWORD + "=?,"
					+ CreateWordDao.USER_AGE + "=?,"
					+ CreateWordDao.USER_GENDER + "=?,"
					+ CreateWordDao.USER_IMG + "=?" + " where user_id="
					+ user_id + ";";
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
	 * @category 更新车辆信息表
	 * @param car_id
	 * @param car_licenseNum
	 * @param user_id
	 * @param car_type
	 * @return
	 */
	public static boolean updateCarInfo(int car_id, String car_licenseNum,
			int user_id, String car_type, String car_img) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "update " + CreateWordDao.CAR_TABLE_NAME + " set "
					+ CreateWordDao.CAR_LICENSENUM + "=?,"
					+ CreateWordDao.USER_ID + "=?," + CreateWordDao.CAR_TYPE
					+ "=?," + CreateWordDao.CAR_IMG + "=? " + "where "
					+ CreateWordDao.CAR_ID + "=" + car_id + ";";
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
	 * @category 更新停车场车位信息
	 * @param park_id
	 * @param park_fee
	 * @param park_isUse
	 * @param park_car
	 * @param park_startTime
	 * @return
	 */
	public static boolean updateParkingLotInfo(int park_id, double park_fee,
			int park_isUse, int park_car, String park_startTime) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "update " + CreateWordDao.PARKINGLOT_TABLE_NAME + " set "
					+ CreateWordDao.PARK_FEE + "=?," + CreateWordDao.PARK_ISUSE
					+ "=?," + CreateWordDao.PARK_CAR + "=?,"
					+ CreateWordDao.PARK_STARTTIME + "=? " + " where "
					+ CreateWordDao.PARK_ID + "=" + park_id + ";";
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
	 * @category 更新停车记录信息
	 * @param record_id
	 * @param car_id
	 * @param record_strartTime
	 * @param record_endTime
	 * @param record_fee
	 * @return
	 */
	public static boolean updateParkingRecordInfo(int record_id, int car_id,
			String record_strartTime, String record_endTime, double record_fee) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "update " + CreateWordDao.PARKINGRECORD_TABLE_NAME + " set "
					+ CreateWordDao.CAR_ID + "=?," + ""
					+ CreateWordDao.RECORD_STARTTIME + "=?,"
					+ CreateWordDao.RECORD_ENDTIME + "=?,"
					+ CreateWordDao.RECORD_FEE + "=? where "
					+ CreateWordDao.RECORD_ID + "=" + record_id + ";";
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
	 * @category 更新管理员信息
	 * @param admin_id
	 * @param admin_user
	 * @param admin_password
	 * @return
	 */
	public static boolean updateAdminInfo(int admin_id, String admin_user,
			String admin_password) {
		boolean flag = false;

		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "update " + CreateWordDao.ADMIN_TABLE_NAME + " set "
					+ CreateWordDao.ADMIN_USER + "=?," + ""
					+ CreateWordDao.ADMIN_PASSWORD + "=? where "
					+ CreateWordDao.ADMIN_ID + "=" + admin_id + ";";
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
}
