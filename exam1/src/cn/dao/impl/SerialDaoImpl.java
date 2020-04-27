package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Serial;
import cn.dao.SerialDao;
import cn.dbc.BaseDao;

public class SerialDaoImpl implements SerialDao {

	BaseDao bs = new BaseDao();

	@Override
	public boolean doSerialId(Serial serial) {
		boolean isFlag = false;
		String sql = "insert into serial(serialName,serialTime,subjectId,classesId) values(?,?,?,?)";
		List<Object> lp = new ArrayList<Object>();
		lp.add(serial.getSerialName());
		lp.add(serial.getSerialTime());
		lp.add(serial.getSubjectId());
		lp.add(serial.getClassesId());
		isFlag=bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public boolean deleteBySerialId(int serialId) {
		boolean isFlag = false;
		String sql = "delete from serial where serialId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(serialId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	public boolean updateBySerialId(int serialId, String serialTime) {
		boolean isFlag = false;
		String sql = "update serial set serialTime=? where serialId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(serialTime);
		lp.add(serialId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public Serial findSerialById(int serialId) {
		Serial serial = null;
		String sql = "select * from serial where serialId=?";
		List<Serial> list=new ArrayList<Serial>();
		List<Object> lp = new ArrayList<Object>();
		lp.add(serialId);
		list=bs.query(sql, lp, Serial.class);
		if (list.size()>0) {
			serial=list.get(0);
		}
		return serial;
	}

	@Override
	public List<Serial> findSerialBySubjectId(int subjectId) {
		List<Serial> list = null;
		String sql = "select * from serial where subjectId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(subjectId);
		list = bs.query(sql, lp, Serial.class);
		return list;
	}

	@Override
	public List<Serial> findSerialByClassesId(int classesId) {
		List<Serial> list = null;
		String sql = "select * from serial where classesId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(classesId);
		list = bs.query(sql, lp, Serial.class);
		return list;
	}

	@Override
	public List<Serial> findALLSerial() {
		List<Serial> list = null;
		String sql = "select * from serial";
		List<Object> lp = new ArrayList<Object>();
		list = bs.query(sql, lp, Serial.class);
		return list;
	}

}
