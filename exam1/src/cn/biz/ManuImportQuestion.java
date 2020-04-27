package cn.biz;

import cn.bean.Question;
import cn.dao.QuestionDao;
import cn.dao.impl.QuestionDaoImpl;

/**
 * 此类用于手动录入试题
 */
public class ManuImportQuestion {
	private static QuestionDao qDao = new QuestionDaoImpl();

	/**
	 * 此方法用于向题库添加判断题
	 * 
	 * @param content
	 *            试题内容
	 * @param selected
	 *            试题内容
	 * @param subId
	 *            试题内容
	 * @param typeId
	 *            试题类型
	 * @return 判断添加试题是否成功
	 */
	public static boolean addTrueOrFalseQuestion(String content, String selected, int subId, int typeId) {
		boolean isFlag = false;
		Question question = new Question();
		question.setQuestionContent(content);
		if (selected.equals("正确")) {
			question.setQuestionAnswer("正确");
		} else {
			question.setQuestionAnswer("错误");
		}
		question.setQuestionSubjectId(subId);
		question.setQuestionTypeId(typeId);
		isFlag = qDao.doQuestion(question);
		return isFlag;

	}

	/**
	 * 此方法用于向题库添加单选题
	 * 
	 * @param content
	 *            试题内容
	 * @param selected
	 *            试题内容
	 * @param subId
	 *            试题内容
	 * @param typeId
	 *            试题类型
	 * @return 判断添加试题是否成功
	 */
	public static boolean addMultipleChoiceQuestion(String content, String selected, int subId, int typeId) {
		boolean isFlag = false;
		Question question = new Question();
		question.setQuestionContent(content);
		if (selected.equals("A")) {
			question.setQuestionAnswer("A");
		} else if (selected.equals("B")) {
			question.setQuestionAnswer("B");
		} else if (selected.equals("C")) {
			question.setQuestionAnswer("C");
		} else {
			question.setQuestionAnswer("D");
		}
		question.setQuestionSubjectId(subId);
		question.setQuestionTypeId(typeId);
		isFlag = qDao.doQuestion(question);
		return isFlag;
	}

	/**
	 * 此方法用于向题库添加多选题
	 * 
	 * @param content
	 *            试题内容
	 * @param selected
	 *            试题内容
	 * @param subId
	 *            试题内容
	 * @param typeId
	 *            试题类型
	 * @return 判断添加试题是否成功
	 */
	public static boolean addMultipleChoicesQuestion(String content, String selected, int subId, int typeId) {
		boolean isFlag = false;
		Question question = new Question();
		question.setQuestionContent(content);
		question.setQuestionAnswer(selected);
		question.setQuestionSubjectId(subId);
		question.setQuestionTypeId(typeId);
		isFlag = qDao.doQuestion(question);
		return isFlag;
	}
}
