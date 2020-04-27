package cn.demo;

import org.junit.Test;

import cn.bean.Question;
import cn.dao.impl.QuestionDaoImpl;

public class TestQuestion {
	
	QuestionDaoImpl qdi = new QuestionDaoImpl();
	
	@Test
	//录题
	public void zhengjia() {
		Question q = new Question("正确答案是？A. B. C. D.", "答案：D", 1, 1);
		System.out.println(
				qdi.doQuestion(q)
			);
	}
	
	@Test
	public void dada() {
		System.out.println(
//				qdi.findQuestion(3).getQuestionContent()
//				qdi.findQuestionBySubjectId(1).get(1).getQuestionContent()
//				qdi.findQuestionBySubnType(2, 1).get(0).getQuestionContent()
				qdi.findAllQuestion().get(1).getQuestionContent()
			);
	}
	

}
