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
	 * �������ڼ���ܷ�μӿ���
	 * 
	 * @param serialId
	 *            ���� ����
	 * @return ���������ʾ��Ϣ
	 */
	public String validateTime(int serialId) {
		/*
		 * ��ȡ����ʱ�����ȡ���Խ���ʱ�䣬�ж��ܷ���뿼��
		 */
		Date date1 = new Date();// ��ǰʱ��
		Date date2 = new Date();// ��ʼ����ʱ��
		Date date3 = new Date();// ���Խ���ʱ��
		Date date4 = new Date();// ���뿼��������ʱ��
		date2 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date3 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date4 = String2Date(serialDao.findSerialById(serialId).getSerialTime());
		date3.setTime(date3.getTime() + 5400000);
		date4.setTime(date4.getTime() + 900000);
		String str;
		if (date1.before(date2)) {
			str = "����ʱ�仹û����";
		} /*
			 * else if (date1.after(date4) && date1.before(date3)) { str = "����볡ʱ�䣬ȡ�������ʸ�";
			 * }
			 */else if (date1.after(date3)) {
			str = "����ʱ���ѹ���";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = simpleDateFormat.format(date3).toString();
			str = time;
		}

		return str;
	}

	/**
	 * ���ڽ��ַ���ʱ��ת��ΪDate���͵�ʱ��
	 * 
	 * @param dateStr
	 *            ʱ���ַ���
	 * @return ��ʽ�����date����
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
