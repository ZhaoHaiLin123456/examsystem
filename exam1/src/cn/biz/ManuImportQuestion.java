package cn.biz;

import cn.bean.Question;
import cn.dao.QuestionDao;
import cn.dao.impl.QuestionDaoImpl;

/**
 * ���������ֶ�¼������
 */
public class ManuImportQuestion {
	private static QuestionDao qDao = new QuestionDaoImpl();

	/**
	 * �˷����������������ж���
	 * 
	 * @param content
	 *            ��������
	 * @param selected
	 *            ��������
	 * @param subId
	 *            ��������
	 * @param typeId
	 *            ��������
	 * @return �ж���������Ƿ�ɹ�
	 */
	public static boolean addTrueOrFalseQuestion(String content, String selected, int subId, int typeId) {
		boolean isFlag = false;
		Question question = new Question();
		question.setQuestionContent(content);
		if (selected.equals("��ȷ")) {
			question.setQuestionAnswer("��ȷ");
		} else {
			question.setQuestionAnswer("����");
		}
		question.setQuestionSubjectId(subId);
		question.setQuestionTypeId(typeId);
		isFlag = qDao.doQuestion(question);
		return isFlag;

	}

	/**
	 * �˷��������������ӵ�ѡ��
	 * 
	 * @param content
	 *            ��������
	 * @param selected
	 *            ��������
	 * @param subId
	 *            ��������
	 * @param typeId
	 *            ��������
	 * @return �ж���������Ƿ�ɹ�
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
	 * �˷��������������Ӷ�ѡ��
	 * 
	 * @param content
	 *            ��������
	 * @param selected
	 *            ��������
	 * @param subId
	 *            ��������
	 * @param typeId
	 *            ��������
	 * @return �ж���������Ƿ�ɹ�
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
