package cn.model;

import java.awt.EventQueue;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.junit.experimental.theories.Theories;

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

public class ExamModel implements ExamAndReviewModel {
	
	String serialName = null;
	String message;

	Jtest examView = null;
	SerialDaoImpl serialDaoImpl = new SerialDaoImpl();
	QuestionDaoImpl questionsDaoImpl = new QuestionDaoImpl();
	RecordDaoImpl rcdDaoImpl = new RecordDaoImpl();
	ResultDaoImpl rsultDaoImpl = new ResultDaoImpl();
	
	List<Question> questionsTemp = new ArrayList<Question>();
	Record_temp recordTemp = new Record_temp();
	Result result = new Result();
	
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
	
	public ExamModel(int studentId, int serialId) {
		recordTemp.setRecordTempStudentId(studentId);
		recordTemp.setRecordTempSerialId(serialId);
		serialName = serialDaoImpl.findSerialById(serialId).getSerialName();
		createQues(serialId);
		initializeRcrd();
		result.setResultStudentId(studentId);
		result.setResultSerialId(serialId);
		result.setSubjectId(serialDaoImpl.findSerialById(serialId).getSubjectId());
		result.setClassesId(serialDaoImpl.findSerialById(serialId).getClassesId());
	}
	
	
	/*
	 * 生成随机的试卷
	 */
	private void createQues(int serialId) {
		int subjectId = serialDaoImpl.findSerialById(serialId).getSubjectId();
		//分题型获取该科目所有题目
		List<Question> allJudgeQues = questionsDaoImpl.findQuestionBySubnType(subjectId, 1);
		List<Question> allSingleQues = questionsDaoImpl.findQuestionBySubnType(subjectId, 2);
		List<Question> allMultiQues = questionsDaoImpl.findQuestionBySubnType(subjectId, 3);
		
		Random random = new Random();
		
		//添加判断题
		do {
			int size = allJudgeQues.size();
			Question q = allJudgeQues.get(random.nextInt(size));
			if(!questionsTemp.contains(q)) {
				questionsTemp.add(q);
			}
		}while (questionsTemp.size()<AmountOfJudge);
		
		//添加单选题
		do {
			int size = allSingleQues.size();
			Question q = allSingleQues.get(random.nextInt(size));
			if(!questionsTemp.contains(q)) {
				questionsTemp.add(q);
			}
		}while (questionsTemp.size()<(AmountOfJudge+AmountOfSingle));
		
		//添加多选题
		do {
			int size = allMultiQues.size();
			Question q = allMultiQues.get(random.nextInt(size));
			if(!questionsTemp.contains(q)) {
				questionsTemp.add(q);
			}
		}while (questionsTemp.size()<AmountOfQues);
	}
	
	/*
	 * 初始化答题记录
	 */
	private void initializeRcrd() {
		int[] queIDs = new int[AmountOfQues];
		for(int i=0; i<queIDs.length; i++) {
			queIDs[i] = questionsTemp.get(i).getQuestionId();
		}
		recordTemp.setRecordTempTitleNumber(queIDs);
		recordTemp.setRecordTempAnswer(new String[AmountOfQues]);
	}



	/*
	 * 切换题目
	 */
	public void switchQuestion(int que_num) {
		examView.updateColor(readCurrentAnswer(), currentQues);
		examView.setQueContext(questionsTemp.get(que_num).getQuestionContent());
		if(que_num<AmountOfJudge) {
			examView.swichToJudge();
			examView.restoreJudge(recordTemp.getRecordTempAnswer(que_num));
		}
		else if(que_num<(AmountOfJudge+AmountOfSingle)&&que_num>=AmountOfJudge) {
			examView.swichToSingle();
			examView.restoreSingle(recordTemp.getRecordTempAnswer(que_num));
		}
		else if(que_num>=(AmountOfJudge+AmountOfSingle)) {
			examView.swichToMulti();
			examView.restoreMulti(recordTemp.getRecordTempAnswer(que_num));
		}
		examView.tagNow(que_num);
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



















	private boolean readCurrentAnswer() {
		String answer = null;
		if(currentQues<AmountOfJudge) {
//			System.out.println(examView.readJudge());
			recordTemp.setRecordTempAnswer(currentQues, answer=examView.readJudge());
		}
		else if(currentQues<(AmountOfJudge+AmountOfSingle)&&currentQues>=AmountOfJudge) {
//			System.out.println(examView.readSingle());
			recordTemp.setRecordTempAnswer(currentQues, answer=examView.readSingle());
		}
		else if(currentQues>=(AmountOfJudge+AmountOfSingle)) {
//			System.out.println(examView.readMulti());
			recordTemp.setRecordTempAnswer(currentQues, answer=examView.readMulti());
		}
		if(answer==null) return false;
		return true;
	}
	
	public void doExam() {
		examView = new Jtest(this);
		examView.setVisible(true);
		examView.setTimeStr(message);
		System.out.println(message);
		Thread thread = new Thread(examView);
		thread.start();
		switchQuestion(0);
	}
	
//	public static void main(String[] args) {
//		ExamModel a = new ExamModel(3001, 1);
//		a.doExam();
//	}
	
	@Override
	public void confirm() {
		Record finalRecord = new Record(recordTemp);
		if (rcdDaoImpl.doRecord(finalRecord)) {
			double score = getScore();
			result.setResultScore(score);
			rsultDaoImpl.doResult(result);
			new Jsuccess().setVisible(true);
			examView.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "提交失败！您已经参加过该场考试了");
		}
		
	}
	
	private double getScore() {
		double score = 0;
		for(int i=0; i<AmountOfQues; i++) {
			if(questionsTemp.get(i).getQuestionAnswer().equals(recordTemp.getRecordTempAnswer(i))) {
				if(i<AmountOfJudge) {
					score += 1;
				}
				else if(i<(AmountOfJudge+AmountOfSingle)&&i>=AmountOfJudge) {
					score += 1;
				}
				else if(i>=(AmountOfJudge+AmountOfSingle)) {
					score += 3;
				}
			}
			
		}
		return score;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	


}
