package com.parkinglot.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test {

	public static void main(String args[]) {
		System.out.println(getTimeDifference("2016-06-01 22:00:00",
				"2016-06-01 23:00:01"));
	}

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
