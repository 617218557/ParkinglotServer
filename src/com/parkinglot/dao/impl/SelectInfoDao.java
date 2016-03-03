package com.parkinglot.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.parkinglot.bean.AdminInfoBean;
import com.parkinglot.bean.CarInfoBean;
import com.parkinglot.bean.IMInfoBean;
import com.parkinglot.bean.ParkingRecordInfoBean;
import com.parkinglot.bean.ParkinglotInfoBean;
import com.parkinglot.bean.UserInfoBean;

/**
 * @category 从数据库中获取信息
 * @author fengyifei
 *
 */
public class SelectInfoDao {
	/**
	 * @category 根据键值对查找用户信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<UserInfoBean> selectUserInfo(String key, String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<UserInfoBean> list = new ArrayList<UserInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.USER_TABLE_NAME + " where "
					+ key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserInfoBean userInfoBean = new UserInfoBean();
				userInfoBean.setUser_id(rs.getInt(CreateWordDao.USER_ID));
				userInfoBean
						.setUser_name(rs.getString(CreateWordDao.USER_NAME));
				userInfoBean.setUser_phoneNum(rs
						.getString(CreateWordDao.USER_PHONENUM));
				userInfoBean.setUser_password(rs
						.getString(CreateWordDao.USER_PASSWORD));
				userInfoBean.setUser_age(rs.getInt(CreateWordDao.USER_AGE));
				userInfoBean.setUser_gender(rs
						.getInt(CreateWordDao.USER_GENDER));
				userInfoBean.setUser_img(rs.getString(CreateWordDao.USER_IMG));

				list.add(userInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 获取所有用户信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<UserInfoBean> selectAllUserInfo() {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<UserInfoBean> list = new ArrayList<UserInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.USER_TABLE_NAME;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserInfoBean userInfoBean = new UserInfoBean();
				userInfoBean.setUser_id(rs.getInt(CreateWordDao.USER_ID));
				userInfoBean
						.setUser_name(rs.getString(CreateWordDao.USER_NAME));
				userInfoBean.setUser_phoneNum(rs
						.getString(CreateWordDao.USER_PHONENUM));
				userInfoBean.setUser_password(rs
						.getString(CreateWordDao.USER_PASSWORD));
				userInfoBean.setUser_age(rs.getInt(CreateWordDao.USER_AGE));
				userInfoBean.setUser_gender(rs
						.getInt(CreateWordDao.USER_GENDER));
				userInfoBean.setUser_img(rs.getString(CreateWordDao.USER_IMG));

				list.add(userInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 根据键值对查找停车场车位信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<ParkinglotInfoBean> selectParkinglotInfo(String key,
			String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<ParkinglotInfoBean> list = new ArrayList<ParkinglotInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.PARKINGLOT_TABLE_NAME
					+ " where " + key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				ParkinglotInfoBean parkinglotInfoBean = new ParkinglotInfoBean();
				parkinglotInfoBean.setPark_id(rs.getInt(CreateWordDao.PARK_ID));
				parkinglotInfoBean.setPark_fee(rs
						.getDouble(CreateWordDao.PARK_FEE));
				parkinglotInfoBean.setPark_isUse(rs
						.getInt(CreateWordDao.PARK_ISUSE));
				parkinglotInfoBean.setPark_car(rs
						.getString(CreateWordDao.PARK_CAR));
				parkinglotInfoBean.setPark_startTime(rs
						.getString(CreateWordDao.PARK_STARTTIME));
				list.add(parkinglotInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 查找停车场所有车位信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<ParkinglotInfoBean> selectParkinglotInfo() {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<ParkinglotInfoBean> list = new ArrayList<ParkinglotInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.PARKINGLOT_TABLE_NAME;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ParkinglotInfoBean parkinglotInfoBean = new ParkinglotInfoBean();
				parkinglotInfoBean.setPark_id(rs.getInt(CreateWordDao.PARK_ID));
				parkinglotInfoBean.setPark_fee(rs
						.getDouble(CreateWordDao.PARK_FEE));
				parkinglotInfoBean.setPark_isUse(rs
						.getInt(CreateWordDao.PARK_ISUSE));
				parkinglotInfoBean.setPark_car(rs
						.getString(CreateWordDao.PARK_CAR));
				parkinglotInfoBean.setPark_startTime(rs
						.getString(CreateWordDao.PARK_STARTTIME));
				list.add(parkinglotInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 查找车辆信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<CarInfoBean> selectCarInfo(String key, String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<CarInfoBean> list = new ArrayList<CarInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.CAR_TABLE_NAME + " where "
					+ key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				CarInfoBean carInfoBean = new CarInfoBean();
				carInfoBean.setCar_id(rs.getInt(CreateWordDao.CAR_ID));
				carInfoBean.setCar_licenseNum(rs
						.getString(CreateWordDao.CAR_LICENSENUM));
				carInfoBean.setCar_type(rs.getString(CreateWordDao.CAR_TYPE));
				carInfoBean.setUser_id(rs.getInt(CreateWordDao.USER_ID));
				carInfoBean.setCar_img(rs.getString(CreateWordDao.CAR_IMG));
				list.add(carInfoBean);
			}
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
		return list;
	}
	
	/**
	 * @category 查找所有车辆信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<CarInfoBean> selectAllCarInfo() {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<CarInfoBean> list = new ArrayList<CarInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.CAR_TABLE_NAME;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CarInfoBean carInfoBean = new CarInfoBean();
				carInfoBean.setCar_id(rs.getInt(CreateWordDao.CAR_ID));
				carInfoBean.setCar_licenseNum(rs
						.getString(CreateWordDao.CAR_LICENSENUM));
				carInfoBean.setCar_type(rs.getString(CreateWordDao.CAR_TYPE));
				carInfoBean.setUser_id(rs.getInt(CreateWordDao.USER_ID));
				carInfoBean.setCar_img(rs.getString(CreateWordDao.CAR_IMG));
				list.add(carInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 根据键值对查找停车记录信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<ParkingRecordInfoBean> selectRecordInfo(String key,
			String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<ParkingRecordInfoBean> list = new ArrayList<ParkingRecordInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.PARKINGRECORD_TABLE_NAME
					+ " where " + key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				ParkingRecordInfoBean recordInfoBean = new ParkingRecordInfoBean();
				recordInfoBean.setCar_id(rs.getInt(CreateWordDao.CAR_ID));
				recordInfoBean.setRecord_endTime(rs
						.getString(CreateWordDao.RECORD_ENDTIME));
				recordInfoBean.setRecord_fee(rs
						.getDouble(CreateWordDao.RECORD_FEE));
				recordInfoBean.setRecord_id(rs.getInt(CreateWordDao.RECORD_ID));
				recordInfoBean.setRecord_startTime(rs
						.getString(CreateWordDao.RECORD_STARTTIME));

				list.add(recordInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 根据user_id查找停车记录
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<ParkingRecordInfoBean> selectRecordInfoByUserId(
			String user_id) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<ParkingRecordInfoBean> list = new ArrayList<ParkingRecordInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.PARKINGRECORD_TABLE_NAME
					+ " where " + CreateWordDao.CAR_ID + " in (select "
					+ CreateWordDao.CAR_ID + " from "
					+ CreateWordDao.CAR_TABLE_NAME + " where "
					+ CreateWordDao.USER_ID + "=?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ParkingRecordInfoBean recordInfoBean = new ParkingRecordInfoBean();
				recordInfoBean.setCar_id(rs.getInt(CreateWordDao.CAR_ID));
				recordInfoBean.setRecord_endTime(rs
						.getString(CreateWordDao.RECORD_ENDTIME));
				recordInfoBean.setRecord_fee(rs
						.getDouble(CreateWordDao.RECORD_FEE));
				recordInfoBean.setRecord_id(rs.getInt(CreateWordDao.RECORD_ID));
				recordInfoBean.setRecord_startTime(rs
						.getString(CreateWordDao.RECORD_STARTTIME));

				list.add(recordInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 根据键值对查找即时通信信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<IMInfoBean> selectIMInfo(String key, String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<IMInfoBean> list = new ArrayList<IMInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.IM_TABLE_NAME + " where "
					+ key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				IMInfoBean imInfoBean = new IMInfoBean();
				imInfoBean.setIm_id(rs.getInt(CreateWordDao.IM_ID));
				imInfoBean.setUser_id(rs.getInt(CreateWordDao.USER_ID));
				imInfoBean
						.setIm_account(rs.getString(CreateWordDao.IM_ACCOUNT));
				imInfoBean.setIm_password(rs
						.getString(CreateWordDao.IM_PASSWORD));
				list.add(imInfoBean);
			}
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
		return list;
	}

	/**
	 * @category 根据键值对查找管理员信息
	 * @param key
	 * @param value
	 * @return
	 */
	public static List<AdminInfoBean> selectAdminInfo(String key, String value) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String className = "com.parkinglot.dao.impl.PublicInfoDao";
		PublicInfoDao info = null;
		String sql = null;

		List<AdminInfoBean> list = new ArrayList<AdminInfoBean>();
		try {
			Class<?> tc = Class.forName(className);
			info = (PublicInfoDao) tc.newInstance();
			conn = info.getConnection();
			sql = "select * from " + CreateWordDao.ADMIN_TABLE_NAME + " where "
					+ key + "=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			rs = ps.executeQuery();
			while (rs.next()) {
				AdminInfoBean adminInfoBean = new AdminInfoBean();
				adminInfoBean.setAdmin_id(rs.getInt(CreateWordDao.ADMIN_ID));
				adminInfoBean.setAdmin_user(rs
						.getString(CreateWordDao.ADMIN_USER));
				adminInfoBean.setAdmin_password(rs
						.getString(CreateWordDao.ADMIN_PASSWORD));

				list.add(adminInfoBean);
			}
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
		return list;
	}

}
