package cn.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bean.Question;

public class QuestionUtil {
	
	/**
	 * �˷������ڹ�������,��ֹ��ȡ��ͬ�����ݵ�����
	 * @param qList  ��Ҫ���˵������б�
	 * @return   ���ع��˺�������б�
	 */
	public static List<Question> questionFilter(List<Question> qList){
		List<Question> questions = new ArrayList<>();
		Map<String, Question> map = new HashMap<>();
		for (Question q : qList) {
			map.put(q.getQuestionContent(), q);
		}
		questions.addAll(map.values());
		return questions;
	}
	
	/**
	 * 
	 * @param qList �����б�
	 * @param count ��ȡ��������Ŀ
	 * @return   ���س�ȡ�������б�
	 */
	public static List<Question> getQuestions(List<Question> qList, int count){
		List<Question> list = questionFilter(qList);
		List<Question> questions = new ArrayList<>();
	    Collections.shuffle(list);   //��List�����������(ϴ���㷨)
	    for (int i = 0; i < count; i++) {
	    	questions.add(list.get(i));
	    }
		return questions;
	}
	
}
