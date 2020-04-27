package cn.dao;

import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import cn.bean.Serial;

public interface SerialDao {

	/**
	 * 添加考试场次
	 * 
	 * @param serial
	 *            一场考试对象
	 * @return 是否添加成功
	 */
	public boolean doSerialId(Serial serial);// 添加一条新的考试场次

	/**
	 * 删除一场考试
	 * 
	 * @param serialId
	 *            考试场次编号
	 * @return 是否成功删除
	 */
	public boolean deleteBySerialId(int serialId);// 删除一条SerialId

	/**
	 * 更改场次信息
	 * 
	 * @param serialId
	 *            考试场次编号
	 * @param serialTime
	 *            考试场次开始时间
	 * @return 是否更新了场次信息
	 */
	public boolean updateBySerialId(int serialId, String serialTime);// 更改场次信息

	/**
	 * 根据场次Id查询场次信息
	 * 
	 * @param serialId
	 *            考试场次编号
	 * @return 返回场次信息
	 */
	public Serial findSerialById(int serialId);// 根据场次Id查询场次信息

	/**
	 * 根据科目查询场次
	 * 
	 * @param subjectId
	 *            科目编号
	 * @return 返回该科目编号的所有场次信息
	 */
	public List<Serial> findSerialBySubjectId(int subjectId);// 根据科目查询场次

	/**
	 * 根据班级查询考试场次
	 * 
	 * @param classesId
	 *            班级编号
	 * @return 返回是该班级编号的所有场次信息
	 */
	public List<Serial> findSerialByClassesId(int classesId);// 根据班级查询考试场次（1班有多少场考试）

	/**
	 * 查询所有考试场次信息
	 * 
	 * @return 返回所有的场次信息
	 */
	public List<Serial> findALLSerial();// 查询所有考试场次信息

}
