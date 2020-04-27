package cn.demo;

import org.junit.Test;

import cn.bean.Teacher;
import cn.dao.TeacherDao;
import cn.dao.impl.TeacherDaoImpl;
import cn.dbc.BaseDao;

public class TextTeacher {
	
	TeacherDao tDao = new TeacherDaoImpl();
	
	@Test
	public void test01() {
		/*
		 * ������ʦ
		 */
		Teacher tea = new Teacher("����","258369147","Ů",2);
		boolean isFlag = false;
		isFlag = tDao.doTeacher(tea);
		if (isFlag) {
			System.out.println("�����ʦ�ɹ�!");
		}
	}
	
	@Test
	public void test02() {
		/*
		 * ������ʦ
		 */
		Teacher tea = tDao.findTeacherById(2003);
		System.out.println(tea.getTeacherName()+"\t"+tea.getTeacherPassword()+"\t"+tea.getTeacherSex()+"\t"+tea.getSubjectId());
	}
	
	@Test
	public void test03() {
		boolean isFlag = false;
		isFlag = tDao.delTeacher(2003);
		if (isFlag) {
			System.out.println("ɾ����ʦ�ɹ�");
		}
	}
	
	@Test
	public void test04() {
		boolean isFlag = false;
		isFlag = tDao.updatePwd(2002, "789456");
		if (isFlag) {
			System.out.println("�޸ĳɹ�");
		}
	}
}
