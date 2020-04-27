package cn.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable {
	/** �淶ʱ���ʽ�ַ��� */
	private String clock;
	/** ��ת����ʱ���ַ��� */
	private String timeStr;
	/** ����ʱ���ܺ����� */
	private long times;

	public Timer() {

	}

	/* String -> Date */
	/***
	 * ���ַ���ʱ��ת��ΪDate���͵�ʱ��
	 * 
	 * @param dateStr�ַ���ʱ��
	 * @return Date���͵�ʱ��
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

	/**
	 * ����ʱ����Ҫʵ�ַ���
	 * 
	 * @param dateStr��������ַ����͵�ʱ��
	 */
	public void getTime(String dateStr) {

		Date end = String2Date(dateStr);

		times = (end.getTime() - 1 - new Date().getTime()) / 1000; // �Զ��嵹��ʱʱ��
		long hour = 0;
		long minute = 0;
		long seconds = 0;

		while (times >= 0) {
			hour = times / 3600;
			minute = (times - hour * 3600) / 60;
			seconds = times - hour * 3600 - minute * 60;
			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(hour).append(":").append(minute).append(":").append(seconds);
			setClock(stringBuilder.toString());
			// System.out.println(clock);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			times--;
		}
	}

	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.getTime("2018-07-23 13:39:00");
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	@Override
	public void run() {
		getTime(timeStr);
	}
}
