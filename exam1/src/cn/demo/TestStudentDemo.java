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
		 * ����ѧ��
		 */
		boolean isFlag = false;
		Student stu = new Student("���","456789","��",3);
		isFlag = stuDao.doStudnet(stu);
		if (isFlag) {
			System.out.println("��ӳɹ�");
		}
	}
	
	@Test
	public void test02() {
		/*
		 * ɾ��ѧ��
		 */
		boolean isFlag = false;
		isFlag = stuDao.deleteStudent(3007);
		if (isFlag) {
			System.out.println("ɾ���ɹ�");
		}
	}
	
	@Test
	public void test03() {
		/*
		 * �޸�ѧ��
		 */
		boolean isFlag = false;
		isFlag = stuDao.updateStuPwd(3001, "456789");
		if (isFlag) {
			System.out.println("�޸ĳɹ�");
		}
	}
	
	@Test
	public void test04() {
		/*
		 * ����ѧ��
		 */
		Student stu = stuDao.findByStudentId(3001);
		System.out.println(stu.getStudentName()+"\t"+stu.getStudentPassword()+"\t"+stu.getStudentSex()+"\t"+stu.getStudentClassId());
	}
	
	@Test
	public void test05() {
		/*
		 * ���Ұ༶����ѧ��
		 */
		List<Student> list = stuDao.findStudentByClassId(1);
		for (Student student : list) {
			System.out.println(student.getStudentName());
		}
	}
}
