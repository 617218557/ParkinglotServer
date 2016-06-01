package com.parkinglot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @category 时间工具类
 * @author fengyifei
 *
 */
public class TimeUtils {

	/**
	 * @category 获取当前时间
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}

	public static String getCurrentTime() {
		return getCurrentTime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @category 与当前时间时间比较
	 * @return 沒到当前时间返回false,在当前时间之后返回true
	 */
	public static boolean comparePointTime(String time) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		try {
			long timeNow = df.parse(dateFormat.format(now)).getTime();
			long timeT = df.parse(time).getTime();
			if (timeNow < timeT)
				return true;
			else
				return false;
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @category 获得时间差（以小时为单位，向上取整）
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int getTimeDifference(String time1, String time2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		long hour = 0;
		try {
			Date now = df.parse(time1);
			Date after = df.parse(time2);
			long timeDiff = after.getTime() - now.getTime();
			if (timeDiff < 0) {
				timeDiff = -timeDiff;
			}
			hour = timeDiff / (60 * 60 * 1000);
			hour += timeDiff % (60 * 60 * 1000) == 0 ? 0 : 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (int) hour;
	}
}
