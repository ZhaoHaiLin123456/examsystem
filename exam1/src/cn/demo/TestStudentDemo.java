package cn.demo;
import java.util.List;


import org.junit.Test;

import cn.bean.Student;
import cn.dao.StudentDao;
import cn.dao.impl.StudentDaoImpl;

public class TestStudentDemo {

	StudentDao stuDao = new StudentDaoImpl();
	
	@Test
	public void test01() {
		/*
		 * 增加学生
		 */
		boolean isFlag = false;
		Student stu = new Student("万份","456789","男",3);
		isFlag = stuDao.doStudnet(stu);
		if (isFlag) {
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void test02() {
		/*
		 * 删除学生
		 */
		boolean isFlag = false;
		isFlag = stuDao.deleteStudent(3007);
		if (isFlag) {
			System.out.println("删除成功");
		}
	}
	
	@Test
	public void test03() {
		/*
		 * 修改学生
		 */
		boolean isFlag = false;
		isFlag = stuDao.updateStuPwd(3001, "456789");
		if (isFlag) {
			System.out.println("修改成功");
		}
	}
	
	@Test
	public void test04() {
		/*
		 * 查找学生
		 */
		Student stu = stuDao.findByStudentId(3001);
		System.out.println(stu.getStudentName()+"\t"+stu.getStudentPassword()+"\t"+stu.getStudentSex()+"\t"+stu.getStudentClassId());
	}
	
	@Test
	public void test05() {
		/*
		 * 查找班级所有学生
		 */
		List<Student> list = stuDao.findStudentByClassId(1);
		for (Student student : list) {
			System.out.println(student.getStudentName());
		}
	}
}
