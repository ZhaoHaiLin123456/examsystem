package cn.dao.impl;


import java.util.ArrayList;
import java.util.List;

import cn.bean.Teacher;
import cn.dao.TeacherDao;
import cn.dbc.BaseDao;
import cn.utils.MD5;

public class TeacherDaoImpl implements TeacherDao {

	BaseDao bs = new BaseDao();
	
	//通过ID查找老师
	@Override
	public Teacher findTeacherById(int id) {
		// TODO 自动生成的方法存根
		Teacher tea = null;
		String sql = "SELECT * FROM teacher WHERE teacherId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(id);
		List<Teacher> list = bs.query(sql, lp, Teacher.class);
		if (list.size() > 0) {
			tea = list.get(0);
		}
		return tea;
	}

	@Override
	public boolean doTeacher(Teacher tea) {
		// TODO 自动生成的方法存根
		boolean isFlag = false;
		String sql = "INSERT INTO teacher(teacherName,teacherPassword,teacherSex,subjectId)"
				+ "VALUES(?,?,?,?)";
		List<Object> lp = new ArrayList<Object>();
		lp.add(tea.getTeacherName());
		lp.add(new MD5().getMD5ofStr(tea.getTeacherPassword()));
		lp.add(tea.getTeacherSex());
		lp.add(tea.getSubjectId());
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public boolean delTeacher(int teaId) {
		boolean isFlag = false;
		String sql = "DELETE FROM teacher WHERE teacherId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(teaId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public boolean updatePwd(int teacherId, String newPwd) {
		boolean isFlag = false;
		String sql = "UPDATE teacher SET teacherPassword = ? WHERE teacherId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(newPwd);
		lp.add(teacherId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public List<Teacher> findTeacherBySubject(int subjectId) {
		List<Teacher> list=null;
		String sql="select * from teacher where subjectId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(subjectId);
		list=bs.query(sql, lp, Teacher.class);
		return list;
	}

}