package com.parkinglot.common;

/**
 * @category 这里约束一些常量定义
 * @author fengyifei
 *
 */
public class GlobalDefine {
	// 用户表
	public static int USER_GENDER_FEMALE = 0; // 女性
	public static int USER_GENDER_MALE = 1; // 男性

	// 停车场表
	public static int PARK_NOT_USED = 0; // 车位未被占用
	public static int PARK_USED = 1; // 车位已被占用
	public static double PARK_FEE = 5.0;// 每小时停车费用

	// 用户注册
	public static int REGIST_FAIL = -1; // 注册失败
	public static int REGIST_EXIST = -2;// 用户已存在

	// 用户登录
	public static int LOGIN_FAIL = -1;// 登录失败
	public static int LOGIN_NOT_EXIST = -2;// 用户不存在
	public static int LOGIN_PASSWORD_ERROR = -3;// 密码错误
	
	// 修改用户信息
	public static int UPDATE_USER_INFO_FAIL =-1;//修改失败
	
	// 修改用户密码
	public static int UPDATE_USER_PASSSWORD_FAIL = -1;// 修改失败
	public static int UPDATE_USER_PASSWORD_ERROR = -2;// 旧密码错误

	// 查找可用车位
	public static int PARK_FIND_FAIL = -2;// 查找失败
	public static int PARK_FIND_NO_NOT_USED = -2;// 暂无可用车位
	
	// 查找已预约车位
	public static int PARK_HAVE_ORDER_FAIL = -1;// 失败
	public static int PARK_NOT_HAVE_ORDER = -2;// 今日无预约

	// 预约车位
	public static int PARK_ORDER_FAIL = -1;// 预约失败
	public static int PARK_ORDER_USED = -2;// 车位已被占用
	public static int PARK_ORDER_TIME_NOT_LEGEL = -3;// 预约时间不合法
	public static int PARK_ORDER_CAR_ORDERED = -4;// 该车辆已经预约车位

	// 取消预约车位
	public static int PARK_CANCLE_FAIL = -1; // 失败

	// 停止停靠
	public static int PARK_END_FAIL = -1;// 失败

	// 查询车辆信息
	public static int CAR_FIND_FAIL = -1;// 失败

	// 添加车辆信息
	public static int CAR_ADD_FAIl = -1;// 失败

	// 更改车辆信息
	public static int CAR_UPDATE_FAIL = -1;// 失败

	// 删除车辆信息
	public static int CAR_DELETE_FAIL = -1;// 失败

	// 根据用户id查询车辆停靠记录信息
	public static int RECORD_FIND_USER_FAIL = -1;// 失败

	// 根据车辆id查询车辆停靠记录信息
	public static int RECORD_FIND_CAR_FAIL = -1;// 失败
	
	// 查找即时通信账户
	public static int IM_FIND_FAIL = -1;
	public static int IM_NOT_REGIST = 2;// 手机号未注册
	
	public static int ERROR_DEFAULT  = -1;

}
