package com.parkinglot.schedule;

import java.util.Calendar;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.parkinglot.service.impl.ParkinglotInfoServiceImpl;

/**
 * @category 每天0点定时清空停车场与预约信息
 * @author fengyifei
 *
 */
public class ClearParkinglot extends HttpServlet implements
		ServletContextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966748059753149216L;
	private static final int C_SCHEDULE_HOUR = 0;// 这个代表3点钟的时候执行任务
	private static boolean isRunning = false;

	private java.util.Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		timer = new java.util.Timer(true);
		event.getServletContext().log("定时器已启动");
		timer.schedule(new MyTask(event.getServletContext()), 0, 60 * 60 * 1000); // 后边最后一个参数代表监视器的监视周期,现在为一小时
		event.getServletContext().log("已经添加任务调度表");

	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		System.out.println("定时器销毁");
		event.getServletContext().log("定时器销毁");
	}

	class MyTask extends TimerTask {
		private ServletContext context = null;
		public MyTask() {
			super();
		}

		public MyTask(ServletContext context) {
			this.context = context;
		}

		public void run() {
			Calendar cal = Calendar.getInstance();
			if (!isRunning) {
				if (C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY)) {
					isRunning = true;
					context.log("开始执行指定任务");
					// 对table空值进行修改,并更改编码标记.
					// 由于在查询时就进行了锁定,防止查询后没有录入数据
					// 此处写执行任务代码
					ParkinglotInfoServiceImpl.clearParkinglot();
					isRunning = false;
					context.log("指定任务执行结束");
				}
			} else {
				context.log("上一次任务执行还未结束");
			}
		}

		public void init() throws ServletException {
			// Put your code here
		}
	}

}
