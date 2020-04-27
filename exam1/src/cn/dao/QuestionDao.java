package cn.dao;

import java.util.List;

import cn.bean.Question;

public interface QuestionDao {

	/**
	 * ���һ����Ŀ
	 * 
	 * @param question
	 *            ¼��һ����Ŀ����
	 * @return�Ƿ�ɹ����һ����Ŀ
	 */
	public boolean doQuestion(Question question);// ¼��һ��question

	/**
	 * ������Ŀ��Ų�����Ŀ
	 * 
	 * @param questionId
	 *            ��Ŀ���
	 * @return���ظ���Ŀ��ŵ���Ŀ
	 */
	public Question findQuestion(int questionId);// ����questionId��ѯ��Ŀ

	/**
	 * ���ݿ�Ŀ��Ų�����Ŀ
	 * 
	 * @param questionSubjectId
	 *            ��Ŀ���
	 * @return����Ϊ�ÿ�Ŀ��ŵ�������Ŀ
	 */
	public List<Question> findQuestionBySubjectId(int questionSubjectId);// ����subjectId��ѯ��Ŀ

	/**
	 * ���ݿ�Ŀ��ź���Ŀ���ͱ�Ų�ѯ��Ŀ
	 * 
	 * @param questionSubjectId
	 *            ��Ŀ���
	 * @param questionTypeId
	 *            ��Ŀ���ͱ��
	 * @return���ϸ���Ŀ��ź���Ŀ���ͱ�ŵ�������Ϣ
	 */
	public List<Question> findQuestionBySubnType(int questionSubjectId, int questionTypeId);// ����subjectId��questionTypeId��ѯ��Ŀ

	/**
	 * ��ѯ������Ŀ
	 * 
	 * @return �������е���Ŀ
	 */
	public List<Question> findAllQuestion();// ��ѯ������Ŀ

}
