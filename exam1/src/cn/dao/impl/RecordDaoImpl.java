package cn.dao.impl;

import java.util.ArrayList;

import java.util.List;

import cn.bean.Record;
import cn.dao.RecordDao;
import cn.dbc.BaseDao;

public class RecordDaoImpl implements RecordDao {

	BaseDao bs = new BaseDao();

	@Override
	public List<Record> findAllRecordByStuId(int stuId) {
		List<Record> list = null;
		String sql = "SELECT * FROM record WHERE recordStudentId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(stuId);
		list = bs.query(sql, lp, Record.class);
		return list;
	}

	@Override
	public List<Record> findAllRecordBySerialId(int serialId) {
		List<Record> list = null;
		String sql = "SELECT * FROM record WHERE recordSerialId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(serialId);
		list = bs.query(sql, lp, Record.class);
		return list;
	}

	@Override
	public Record findRecordByStuIdAndSerialId(int stuId, int serialId) {
		Record record = null;
		String sql = "SELECT * FROM record WHERE recordStudentId = ? AND recordSerialId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(stuId);
		lp.add(serialId);
		List<Record> list = bs.query(sql, lp, Record.class);
		if (list.size() > 0) { // 判断查询结果是否为空
			record = (Record) list.get(0);
		}
		return record;
	}

	@Override
	public boolean doRecord(Record record) {
		boolean isFlag = false;
		String sql = "INSERT INTO record (recordStudentId,recordTitleNumber,recordSerialId,recordAnswer)"
				+ "VALUES (?,?,?,?)";
		List<Object> lp = new ArrayList<Object>();
		lp.add(record.getRecordStudentId());
		lp.add(record.getRecordTitleNumber());
		lp.add(record.getRecordSerialId());
		lp.add(record.getRecordAnswer());
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

}
