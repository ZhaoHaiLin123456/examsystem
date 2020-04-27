package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.LongLongSeqHelper;

import cn.bean.Result;
import cn.dao.ResultDao;
import cn.dbc.BaseDao;

public class ResultDaoImpl implements ResultDao {
	BaseDao bs = new BaseDao();

	@Override
	public boolean doResult(Result result) {
		boolean isFlag = false;
		String sql = "insert into result(resultStudentId,resultSerialId,resultScore,subjectId,classesId) values(?,?,?,?,?)";
		List<Object> lp = new ArrayList<Object>();
		lp.add(result.getResultStudentId());
		lp.add(result.getResultSerialId());
		lp.add(result.getResultScore());
		lp.add(result.getSubjectId());
		lp.add(result.getClassesId());
		bs.update(sql, lp);
		return isFlag;
	}

	@Override
	public List<Result> findResult(int studentId, int resultSerialId, int classesId,int subjectId) {
		List<Result> re = null;
		String sql;
		List<Object> lp = new ArrayList<Object>();
		if (studentId!=-1) {
			if (resultSerialId==-1&&classesId==-1&&subjectId==-1) {
				sql="select * from result where resultStudentId=?";
				lp.add(studentId);
			}else if (classesId==-1&&subjectId==-1) {
				sql="select * from result where resultStudentId=? and resultSerialId=? ";
				System.out.println("场次");
				lp.add(studentId);
				lp.add(resultSerialId);
				System.out.println(studentId);
				System.out.println(resultSerialId);
			}else if (resultSerialId==-1&&classesId==-1) {
				System.out.println("subject");
				sql="select * from result where resultStudentId=? and subjectId=? ";
				lp.add(studentId);
				lp.add(subjectId);
				System.out.println(resultSerialId);
				System.out.println(subjectId);
			}else {
				sql="select * from result where resultStudentId=? and resultSerialId=? and subjectId=?";
				lp.add(studentId);
				lp.add(resultSerialId);
				lp.add(subjectId);
				System.out.println(studentId);
				System.out.println(subjectId);
				System.out.println(resultSerialId);
			}
		}
		else {
			if (resultSerialId==-1&&classesId==-1&&subjectId!=-1) {
				sql="select * from result where subjectId=?";
				lp.add(subjectId);
				System.out.println("进入页面");
				System.out.println(studentId+"\t"+resultSerialId+"\t"+classesId+"\t"+subjectId);
			}else if (resultSerialId==-1&&classesId!=-1) {
				sql="select * from result where subjectId=? and classesId=?";
				lp.add(subjectId);
				lp.add(classesId);
				System.out.println("根据班级查询");
				System.out.println(studentId+"\t"+resultSerialId+"\t"+classesId+"\t"+subjectId);
			}else if (resultSerialId!=-1&&classesId==-1) {
				sql="select * from result where subjectId=? and resultSerialId=?";
				lp.add(subjectId);
				lp.add(resultSerialId);
				System.out.println("只根据场次查询");
				System.out.println(studentId+"\t"+resultSerialId+"\t"+classesId+"\t"+subjectId);
			}else {
				System.out.println("根据场次和班级查询");
				sql="select * from result where subjectId=? and classesId=? and resultSerialId=? ";
				lp.add(subjectId);
				lp.add(classesId);
				lp.add(resultSerialId);
				System.out.println(studentId+"\t"+resultSerialId+"\t"+classesId+"\t"+subjectId);
			}	
		}
		re = bs.query(sql, lp, Result.class);
		return re;
	}

	@Override
	public List<Result> findAllResult() {
		List<Result> le = null;
		String sql = "select * from result";
		List<Object> lp = new ArrayList<Object>();
		le = bs.query(sql, lp, Result.class);
		return le;
	}

}
