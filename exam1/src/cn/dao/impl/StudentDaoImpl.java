package cn.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Student;
import cn.dao.StudentDao;
import cn.dbc.BaseDao;
import cn.utils.MD5;

public class StudentDaoImpl implements StudentDao {
	BaseDao bs = new BaseDao();

	// 添加新科目
	@Override
	public boolean doStudnet(Student student) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = " Insert into student(studentId,studentName,studentPassword,studentSex,studentClassId)"
				+ "values(?,?,?,?,?) ";
		lp.add(student.getStudentId());
		lp.add(student.getStudentName());
		lp.add(new MD5().getMD5ofStr(student.getStudentPassword()));
		lp.add(student.getStudentSex());
		lp.add(student.getStudentClassId());
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "delete from Student where studentId=? ";
		lp.add(studentId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public boolean updateStuPwd(int studentId, String newPwd) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "update student set studentPassword=? where studentId=? ";
		lp.add(newPwd);
		lp.add(studentId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public Student findByStudentId(int studentId) {
		Student st = null;
		String sql = "select * from student where studentId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(studentId);
		List<Student> list = bs.query(sql, lp, Student.class);
		if (list.size() > 0) {
			st = list.get(0);
		}
		return st;
	}

	@Override
	public List<Student> findStudentByClassId(int classId) {
		List<Student> list = null;
		String sql = "  select * from student where studentClassId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(classId);
		list = bs.query(sql, lp, Student.class);
		return list;
	}

}
