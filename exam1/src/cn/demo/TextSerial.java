package cn.demo;

import java.util.List;

import org.junit.Test;

import cn.bean.Serial;
import cn.dao.SerialDao;
import cn.dao.impl.SerialDaoImpl;

public class TextSerial {

	
	@Test
	public void textDoSerialId()
	{
		SerialDao serialDao=new SerialDaoImpl();
		Serial serial=new Serial("¿Î…¢ ˝—ß", "2018-7-28 09:00:00", 2, 1);
		boolean isFlay=serialDao.doSerialId(serial);
		System.out.println(isFlay);
	}
	
	@Test
	public void textdeleteBySerialId()
	{
		SerialDao serialDao=new SerialDaoImpl();
		boolean isFlay=serialDao.deleteBySerialId(4);
		System.out.println(isFlay);
	}
	
	@Test
	public void textupdateBySerialId()
	{
		SerialDao serialDao=new SerialDaoImpl();
		boolean isFlay=serialDao.updateBySerialId(6,"2018-04-25");
		System.out.println(isFlay);
	}
	
	@Test
	public void textfindSerialById()
	{
		SerialDao serialDao=new SerialDaoImpl();
		Serial serial=serialDao.findSerialById(6);
		System.out.println(serial.toString());
	}
	
	@Test
	public void textfindSerialBySubjectId()
	{
		SerialDao serialDao=new SerialDaoImpl();
		List<Serial> ls=serialDao.findSerialBySubjectId(1);
		for (Serial serial2 : ls) {
			System.out.println(serial2.toString());
		}
	}
	
	@Test
	public void textfindSerialByClassesId()
	{
		SerialDao serialDao=new SerialDaoImpl();
		List<Serial> ls=serialDao.findSerialByClassesId(1);
		for (Serial serial2 : ls) {
			System.out.println(serial2.toString());
		}
	}
	
	@Test
	public void textfindALLSerial()
	{
		SerialDao serialDao=new SerialDaoImpl();
		List<Serial> ls=serialDao.findALLSerial();
		for (Serial serial2 : ls) {
			System.out.println(serial2.toString());
		}
	}
}
