package cn.dao;

import java.util.List;

import cn.bean.Subject;

public interface SubjectDao {

	/**
	 * 添加新科目
	 * 
	 * @param subject
	 *            科目
	 * @return 是否添加成功
	 */
	public boolean doSubject(Subject subject);// 添加新科目

	/**
	 * 通过科目编号删除科目
	 * 
	 * @param subjectId
	 *            科目编号
	 * @return 是否删除成功
	 */
	public boolean deleteSubjctById(int subjectId);// 通过学科目ID删除科目

	/**
	 * 更新科目名字
	 * 
	 * @param subjectNewName
	 *            科目名字
	 * @param subjectId
	 *            科目编号
	 * @return 是否更新成功
	 */
	public boolean updateSubjectById(String subjectNewName, int subjectId);// 通过学科id更改信息

	/**
	 * 通过科目id查找科目
	 * 
	 * @param subjectId
	 *            科目编号
	 * @return 返回符合该科目编号的科目信息
	 */
	public Subject findSubjectById(int subjectId);// 通过科目id查找科目

	/**
	 * 查找所有的科目信息
	 * 
	 * @return 返回所有的科目信息
	 */
	public List<Subject> findAllSubject();

}
