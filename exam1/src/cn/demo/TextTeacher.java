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
		 * 增加老师
		 */
		Teacher tea = new Teacher("张三","258369147","女",2);
		boolean isFlag = false;
		isFlag = tDao.doTeacher(tea);
		if (isFlag) {
			System.out.println("添加老师成功!");
		}
	}
	
	@Test
	public void test02() {
		/*
		 * 查找老师
		 */
		Teacher tea = tDao.findTeacherById(2003);
		System.out.println(tea.getTeacherName()+"\t"+tea.getTeacherPassword()+"\t"+tea.getTeacherSex()+"\t"+tea.getSubjectId());
	}
	
	@Test
	public void test03() {
		boolean isFlag = false;
		isFlag = tDao.delTeacher(2003);
		if (isFlag) {
			System.out.println("删除老师成功");
		}
	}
	
	@Test
	public void test04() {
		boolean isFlag = false;
		isFlag = tDao.updatePwd(2002, "789456");
		if (isFlag) {
			System.out.println("修改成功");
		}
	}
}
