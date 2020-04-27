package cn.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.dao.SerialDao;
import cn.dao.impl.SerialDaoImpl;

public class TimeVerification {

	SerialDao serialDao = new SerialDaoImpl();

	public TimeVerification() {

	}

	/**
	 * 方法用于检查能否参加考试
	 * 
	 * @param serialId
	 *            考试 场次
	 * @return 检查结果的提示信息
	 */
	public String validateTime(int serialId) {
		/*
		 * 读取考试时间表，获取考试结束时间，判断能否进入考场
		 */
		Date date1 = new Date();// 当前时间
		Date date2 = new Date();// 开始考试时间
		Date date3 = new Date();// 考试结束时间
		Date date4 = new Date();// 进入考场的限制时间
		date2 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date3 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date4 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date3.setTime(date3.getTime() + 5400000);
		date4.setTime(date4.getTime() + 900000);
		String str;
		if (date1.before(date2)) {
			str = "考试时间还没到！";
		} /*
			 * else if (date1.after(date4) && date1.before(date3)) { str = "错过入场时间，取消考试资格！";
			 * }
			 */else if (date1.after(date3)) {
			str = "考试时间已过！";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = simpleDateFormat.format(date3).toString();
			str = time;
		}

		return str;
	}

	/**
	 * 用于将字符串时间转换为Date类型的时间
	 * 
	 * @param dateStr
	 *            时间字符串
	 * @return 格式化后的date对象
	 */
	private Date String2Date(String dateStr) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = simpleDateFormat.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
