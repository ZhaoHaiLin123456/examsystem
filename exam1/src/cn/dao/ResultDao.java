package cn.dao;

import java.util.List;

import cn.bean.Result;
import cn.bean.Student;

public interface ResultDao {
	/**
	 * 添加一条考试记录
	 * 
	 * @param result
	 *            考试记录
	 * @return返回是否添加成功
	 */
	public boolean doResult(Result result);// 添加一条记录

	/**
	 * 根据学生编号，考试编号，班级编号，科目编号
	 * 
	 * @param studentId
	 *            学生编号
	 * @param resultSerialId
	 *            考试编号
	 * @param classesId
	 *            班级编号
	 * @param subjectId
	 *            科目编号
	 * @return 返回符合的学生成绩
	 */
	public List<Result> findResult(int studentId, int resultSerialId, int classesId, int subjectId);// 根据studentId和SerialId查询成绩

	/**
	 * 查询所有学生所有成绩
	 * 
	 * @return 返回所有的学生的成绩信息
	 */
	public List<Result> findAllResult();// 查询所有学生所有成绩

}
