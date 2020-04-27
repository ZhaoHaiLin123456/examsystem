package cn.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Subject;
import cn.dao.SubjectDao;
import cn.dbc.BaseDao;

public class SubjectDaoImpl implements SubjectDao {
	BaseDao bs = new BaseDao();

	// 添加新科目
	@Override
	public boolean doSubject(Subject subject) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = " Insert into subject(subjectName) values(?) ";
		lp.add(subject.getSubjectName());
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	// 通过学科目ID删除科目
	@Override
	public boolean deleteSubjctById(int subjectId) {

		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "delete from subject where subjectId=? ";
		lp.add(subjectId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	// 通过学科id更改信息
	@Override
	public boolean updateSubjectById(String subjectNewName, int subjectId) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "update subject set subjectName =? where subjectId=?";
		lp.add(subjectNewName);
		lp.add(subjectId);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}

	// 通过科目id查找科目
	@Override
	public Subject findSubjectById(int subjectId) {
		Subject subject = null;
		List<Subject> list=new ArrayList<Subject>();
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from subject where subjectId=?";
		lp.add(subjectId);
		list =  bs.query(sql, lp, Subject.class);
		if (list.size()>0) {
			subject=list.get(0);
		}
		return subject;
	}

	@Override
	public List<Subject> findAllSubject() {
		List<Subject> list=null;
		List<Object> lp = new ArrayList<Object>();
		String sql="select * from subject";
		list=bs.query(sql, lp, Subject.class);
		return list;
	}

}
