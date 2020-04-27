package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Question;
import cn.dao.QuestionDao;
import cn.dbc.BaseDao;

public class QuestionDaoImpl implements QuestionDao {

	BaseDao bs=new BaseDao();

	@Override
	public boolean doQuestion(Question question) {
		String sql="insert into question(questionContent,questionAnswer,"
				+ "questionSubjectId,questionTypeId) values(?, ?, ?, ?)";
		List<Object> lp=new ArrayList<Object>();
		lp.add(question.getQuestionContent());
		lp.add(question.getQuestionAnswer());
		lp.add(question.getQuestionSubjectId());
		lp.add(question.getQuestionTypeId());
		return bs.update(sql, lp);
	}

	@Override
	public Question findQuestion(int questionId) {
		Question question=null;
		List<Question> list=new ArrayList<Question>();
		String sql="select * from question where questionId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(questionId);
		list=bs.query(sql, lp, Question.class);
		if (list.size()>0) {
			question=list.get(0);
		}
		return question;
	}

	@Override
	public List<Question> findQuestionBySubjectId(int questionSubjectId) {
		List<Question> list=null;
		String sql="select * from question where questionSubjectId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(questionSubjectId);
		list =  bs.query(sql, lp, Question.class);
		return list;
	}

	@Override
	public List<Question> findQuestionBySubnType(int questionSubjectId, int questionTypeId) {
		List<Question> list=null;
		String sql="select * from question where questionSubjectId=? and questionTypeId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(questionSubjectId);
		lp.add(questionTypeId);
		list =  bs.query(sql, lp, Question.class);
		return list;
	}

	@Override
	public List<Question> findAllQuestion() {
		List<Question> list=null;
		String sql="select * from question";
		List<Object> lp=new ArrayList<Object>();
		list =  bs.query(sql, lp, Question.class);
		return list;
	}

}
