package cn.dao;

import java.util.List;

import cn.bean.Teacher;

public interface TeacherDao {

	/**
	 * 通过科目编号查找科目
	 * 
	 * @param id
	 *            科目编号
	 * @return 返回该科目编号的教师
	 */
	public Teacher findTeacherById(int id); // 通过科目编号查找科目

	/**
	 * 添加一个教师
	 * 
	 * @param tea
	 *            一个老师信息
	 * @return 是否添加成功
	 */
	public boolean doTeacher(Teacher tea); // 添加老师

	/**
	 * 删除一个教师
	 * 
	 * @param teaId
	 *            教师编号
	 * @return 是否删除成功
	 */
	public boolean delTeacher(int teaId); // 删除老师

	/**
	 * 修改教师用户密码
	 * 
	 * @param teacherId
	 *            教师编号
	 * @param newPwd
	 *            教师密码
	 * @return 是否修改密码成功
	 */
	public boolean updatePwd(int teacherId, String newPwd); // 修改密码

	/**
	 * 根据科目编号查询教师信息
	 * 
	 * @param subjectId
	 *            科目编号
	 * @return 返回所有符合该科目编号的所有教师信息
	 */
	public List<Teacher> findTeacherBySubject(int subjectId);

}