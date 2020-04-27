package cn.dao;

import java.util.List;

import cn.bean.Record;

public interface RecordDao {

	/**
	 * 根据学生编号查找所有答题记录
	 * 
	 * @param stuId
	 *            学生编号
	 * @return 返回该学生编号的所有答题记录
	 */
	public List<Record> findAllRecordByStuId(int stuId); // 根据学生Id查找所有答题记录

	/**
	 * 根据场次查找所有的答题记录
	 * 
	 * @param serialId
	 *            考试场次编号
	 * @return 返回符合该考试场次编号的所有答题记录
	 */
	public List<Record> findAllRecordBySerialId(int serialId); // 根据场次查找所有答题记录

	/**
	 * 根据学生编号和考试场次编号查询答题记录
	 * 
	 * @param stuId
	 *            学生编号
	 * @param serialId
	 *            考试场次编号
	 * @return 返回符合该学生编号和考试场次编号的的所有答题记录
	 */
	public Record findRecordByStuIdAndSerialId(int stuId, int serialId); // 根据学生Id和考试场次Id查询答题记录

	/**
	 * 添加答题记录
	 * 
	 * @param record
	 *            一个答题记录对象
	 * @return 是否成功添加一条答题记录
	 */
	public boolean doRecord(Record record); // 添加答题记录

}
