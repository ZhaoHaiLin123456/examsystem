package cn.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import cn.bean.Question;
import cn.bean.Record;
import cn.bean.Record_temp;
import cn.bean.Result;
import cn.dao.impl.QuestionDaoImpl;
import cn.dao.impl.RecordDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.SerialDaoImpl;
import cn.view.Jsuccess;
import cn.view.Jtest;


public class ReviewModel implements ExamAndReviewModel {
	
	String serialName = null;

	Jtest reviewView = null;
	SerialDaoImpl serialDaoImpl = new SerialDaoImpl();
	QuestionDaoImpl questionsDaoImpl = new QuestionDaoImpl();
	RecordDaoImpl rcdDaoImpl = new RecordDaoImpl();
	
	List<Question> questionsTemp = new ArrayList<Question>();
	Record_temp recordTemp = new Record_temp();
	
	/*
	 * 当前所在的题目ID
	 */
	private int currentQues = 0;

	public int getCurrentQues() {
		return currentQues;
	}
	
	/*
	 * 各题型题量，此版本暂不可用
	 */
	private int AmountOfJudge = 20;
	private int AmountOfSingle = 20;
	private int AmountOfMulti = 20;
	private int AmountOfQues = AmountOfJudge+AmountOfSingle+AmountOfMulti;

	public int getAmountOfJudge() {
		return AmountOfJudge;
	}
	public int getAmountOfSingle() {
		return AmountOfSingle;
	}
	public int getAmountOfMulti() {
		return AmountOfMulti;
	}
	public int getAmountOfQues() {
		return AmountOfQues;
	}
	
	@Override
	public String getSerialName() {
		return serialName;
	}
	
	public ReviewModel(int studentId, int serialId) {
		recordTemp.setRecordTempStudentId(studentId);
		recordTemp.setRecordTempSerialId(serialId);
		serialName = serialDaoImpl.findSerialById(serialId).getSerialName();
		restoreRcd(studentId, serialId);
		initializeQues();
	}
	
	private void restoreRcd(int studentId, int serialId) {
		recordTemp = new Record_temp(rcdDaoImpl.findRecordByStuIdAndSerialId(studentId, serialId));
	}
	private void initializeQues() {
		for(int i=0; i<AmountOfQues; i++) {
			questionsTemp.add(i, questionsDaoImpl.findQuestion(recordTemp.getRecordTempTitleNumber(i)));
		}
	}
	private void setColor() {
		for(int i=0; i<AmountOfQues; i++) {
			if(recordTemp.getRecordTempAnswer(i)!=null) {
				boolean isCorrect = recordTemp.getRecordTempAnswer(i).equals(questionsTemp.get(i).getQuestionAnswer());
				reviewView.setColor_review(isCorrect, i);
			}
		}
//		reviewView.flushColor(0);
	}
	
	
	/*
	 * 切换题目
	 */
	public void switchQuestion(int que_num) {
		reviewView.setQueContext(questionsTemp.get(que_num).getQuestionContent());
		reviewView.setCorrectAnswer(questionsTemp.get(que_num).getQuestionAnswer());
		if(que_num<AmountOfJudge) {
			reviewView.swichToJudge();
			reviewView.restoreJudge(recordTemp.getRecordTempAnswer(que_num));
		}
		else if(que_num<(AmountOfJudge+AmountOfSingle)&&que_num>=AmountOfJudge) {
			reviewView.swichToSingle();
			reviewView.restoreSingle(recordTemp.getRecordTempAnswer(que_num));
		}
		else if(que_num>=(AmountOfJudge+AmountOfSingle)) {
			reviewView.swichToMulti();
			reviewView.restoreMulti(recordTemp.getRecordTempAnswer(que_num));
		}
		reviewView.setButtonTrue(currentQues);
		reviewView.setButtonFalse(que_num);
		currentQues = que_num;
	}
	public void nextQuestion() {
		if(currentQues<AmountOfQues-1) {
			switchQuestion(currentQues+1);
		}
	}
	public void lastQuestion() {
		if(currentQues>0) {
			switchQuestion(currentQues-1);
		}
	}



















	
	
	public void doReview() {
		reviewView = new Jtest(this);
		reviewView.setSelectionDisable();
		setColor();
		reviewView.setVisible(true);
		switchQuestion(0);
	}
	
	public static void main(String[] args) {
		ReviewModel a = new ReviewModel(3001, 1);
		a.doReview();
	}
	@Override
	public void confirm() {	}
	
	

}

