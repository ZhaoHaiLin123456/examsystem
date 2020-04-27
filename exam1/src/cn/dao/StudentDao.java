package cn.dao;

import java.util.List;

import cn.bean.Student;

public interface StudentDao {
	/**
	 * 增加学生
	 * 
	 * @param student
	 *            一个学生
	 * @return 是否添加成功
	 */
	public boolean doStudnet(Student student);// 增

	/**
	 * 根据学生学号删除一条学生记录
	 * 
	 * @param studentId
	 *            学生编号
	 * @return 是否删除成功
	 */
	public boolean deleteStudent(int studentId);// 删

	/**
	 * 修改学生密码
	 * 
	 * @param studentId
	 *            学生编号
	 * @param newPwd
	 *            输入的新密码
	 * @return 是否更新成功
	 */
	public boolean updateStuPwd(int studentId, String newPwd); // 改

	/**
	 * 通过学生学号查找学生
	 * 
	 * @param studentId
	 *            学生编号
	 * @return 返回是该学生学号的学生
	 */
	public Student findByStudentId(int studentId);// 通过学生学号查找学生

	/**
	 * 通过班级号查找对应班级的所有学生
	 * 
	 * @param ClassId
	 *            班级编号
	 * @return 返回该班级编号的所有学生信息
	 */
	public List<Student> findStudentByClassId(int ClassId);// 通过班级号查找对应班级的所有学生

}
