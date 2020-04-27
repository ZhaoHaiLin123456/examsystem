package cn.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bean.Question;

public class QuestionUtil {
	
	/**
	 * 此方法用于过滤试题,防止抽取到同样内容的试题
	 * @param qList  需要过滤的试题列表
	 * @return   返回过滤后的试题列表
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
	 * @param qList 试题列表
	 * @param count 抽取的试题数目
	 * @return   返回抽取的试题列表
	 */
	public static List<Question> getQuestions(List<Question> qList, int count){
		List<Question> list = questionFilter(qList);
		List<Question> questions = new ArrayList<>();
	    Collections.shuffle(list);   //对List集合随机排序(洗牌算法)
	    for (int i = 0; i < count; i++) {
	    	questions.add(list.get(i));
	    }
		return questions;
	}
	
}
