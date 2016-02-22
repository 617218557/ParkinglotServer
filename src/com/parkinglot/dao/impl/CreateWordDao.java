package com.parkinglot.dao.impl;

/**
 * @category 建表
 * @author fengyifei
 *
 */
public class CreateWordDao {
	// 表名、字段名
	/**
	 * //用户信息表
	 */
	public static String USER_TABLE_NAME = "t_user";
	public static String USER_ID = "user_id";
	public static String USER_NAME = "user_name";
	public static String USER_PHONENUM = "user_phoneNum";
	public static String USER_PASSWORD = "user_password";
	public static String USER_AGE = "user_age";
	public static String USER_GENDER = "user_gender";
	public static String USER_IMG = "user_img";

	/**
	 * 车辆信息表
	 */
	public static String CAR_TABLE_NAME = "t_car";
	public static String CAR_ID = "car_id";
	public static String CAR_LICENSENUM = "car_licenseNum";
	public static String CAR_TYPE = "car_type";
	public static String CAR_IMG = "car_img";

	/**
	 * 停车场表
	 */
	public static String PARKINGLOT_TABLE_NAME = "t_parkinglot";
	public static String PARK_ID = "park_id";
	public static String PARK_FEE = "park_fee";
	public static String PARK_ISUSE = "park_isUse";
	public static String PARK_CAR = "park_car";
	public static String PARK_STARTTIME = "park_startTime";

	/**
	 * 停车记录表
	 */
	public static String PARKINGRECORD_TABLE_NAME = "t_parkingRecord";
	public static String RECORD_ID = "record_id";
	public static String RECORD_STARTTIME = "record_strartTime";
	public static String RECORD_ENDTIME = "record_endTime";
	public static String RECORD_FEE = "record_fee";

	/**
	 * 管理员表
	 */
	public static String ADMIN_TABLE_NAME = "t_admin"; 
	public static String ADMIN_ID = "admin_id";
	public static String ADMIN_USER = "admin_user";
	public static String ADMIN_PASSWORD = "admin_password";

	 /**
	  * 即时通信表
	  */
	public static String IM_TABLE_NAME = "t_im";
	public static String IM_ID  = "im_id";
	public static String IM_ACCOUNT = "im_account";
	public static String IM_PASSWORD = "im_password";

	// 用户信息表的字段
	public static String createUserWord = "create table " + USER_TABLE_NAME
			+ "(" + USER_ID + " int primary key AUTO_INCREMENT COMMENT '用户编号',"
			+ USER_NAME + " char(255) COMMENT '姓名'," + USER_PHONENUM
			+ " char(11) not null COMMENT '电话'," + USER_PASSWORD
			+ " char(255) not null COMMENT '密码'," + USER_AGE
			+ " INT COMMENT '年龄'," + USER_GENDER
			+ " INT not null COMMENT '性别'," + USER_IMG
			+ " char(255) COMMENT '头像')default charset=utf8;";

	// 车辆表的字段
	public static String createCarWord = "create table " + CAR_TABLE_NAME + "("
			+ CAR_ID + " int primary key AUTO_INCREMENT COMMENT '车辆编号',"
			+ CAR_LICENSENUM + " char(255) COMMENT '车牌号'," + USER_ID
			+ " int not null COMMENT '与用户表关联'," + CAR_TYPE
			+ " char(255) COMMENT '车辆类型'," + CAR_IMG
			+ " char(255) COMMENT '车辆图片'," + "foreign key (" + USER_ID
			+ ") references " + USER_TABLE_NAME + "(" + USER_ID
			+ ") on update cascade on delete cascade)default charset=utf8;";

	// 停车场表
	public static String createParkinglotWord = "create table "
			+ PARKINGLOT_TABLE_NAME + "(" + PARK_ID
			+ " int primary key AUTO_INCREMENT COMMENT '车位编号'," + PARK_FEE
			+ " double not null COMMENT '每小时费用'," + PARK_ISUSE
			+ " int not null COMMENT '车位是否被占用'," + PARK_CAR
			+ " char(255) COMMENT '停靠车辆信息'," + PARK_STARTTIME
			+ " char(255) COMMENT '停靠开始时间')default charset=utf8;";

	// 停车记录表
	public static String createParkingRecordWord = "create table "
			+ PARKINGRECORD_TABLE_NAME + "(" + RECORD_ID
			+ " int primary key AUTO_INCREMENT COMMENT '记录编号'," + CAR_ID
			+ " int not null COMMENT '与车辆表的车辆id关联'," + RECORD_STARTTIME
			+ " char(255) not null COMMENT '停靠开始时间'," + RECORD_ENDTIME
			+ " char(255) COMMENT '停靠结束时间'," + RECORD_FEE
			+ " double COMMENT '停靠计费'," + "foreign key (" + CAR_ID
			+ ") references " + CAR_TABLE_NAME + "(" + CAR_ID
			+ ") on update cascade on delete cascade)default charset=utf8;";

	// 管理员表
	public static String createAdminWord = "create table " + ADMIN_TABLE_NAME
			+ "(" + ADMIN_ID
			+ " int primary key AUTO_INCREMENT COMMENT '管理员id'," + ADMIN_USER
			+ " char(255) not null COMMENT '管理员账号'," + ADMIN_PASSWORD
			+ " char(255) not null COMMENT '管理员密码')default charset=utf8;";
	
	// 即时通信表
	public static String createIMWord = "create table " + IM_TABLE_NAME
			+ "(" + IM_ID
			+ " int primary key AUTO_INCREMENT COMMENT '即时通信用户id'," 
			+ USER_ID +" int not null COMMENT '用户id',"
			+ IM_ACCOUNT + " char(255) not null COMMENT '用户账户'," + IM_PASSWORD
			+ " char(255) not null COMMENT '即时通信密码')default charset=utf8;";

	// 建表
	public static boolean createAllTable() {
		boolean flag = false;
		if (CreateTableDao.createTable(createUserWord, USER_TABLE_NAME)) {
			if (CreateTableDao.createTable(createCarWord, CAR_TABLE_NAME)) {
				if (CreateTableDao.createTable(createParkinglotWord,
						PARKINGLOT_TABLE_NAME)) {
					if (CreateTableDao.createTable(createParkingRecordWord,
							PARKINGRECORD_TABLE_NAME)) {
						if (CreateTableDao.createTable(createAdminWord,
								ADMIN_TABLE_NAME)) {
							if(CreateTableDao.createTable(createIMWord,
									IM_TABLE_NAME)){
							flag = true;
							}else{
								System.out.println("创建即时通信表失败");
							}
						} else {
							System.out.println("创建管理员表失败");
						}
					} else {
						System.out.println("创建停车记录表失败");
					}
				} else {
					System.out.println("创建停车表失败");
				}
			} else {
				System.out.println("创建车辆表失败");
			}
		} else {
			System.out.println("创建用户表失败");
		}

		return flag;
	}

}