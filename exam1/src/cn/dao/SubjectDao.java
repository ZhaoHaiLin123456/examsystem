package cn.dao;

import java.util.List;

import cn.bean.Subject;

public interface SubjectDao {

	/**
	 * ����¿�Ŀ
	 * 
	 * @param subject
	 *            ��Ŀ
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean doSubject(Subject subject);// ����¿�Ŀ

	/**
	 * ͨ����Ŀ���ɾ����Ŀ
	 * 
	 * @param subjectId
	 *            ��Ŀ���
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteSubjctById(int subjectId);// ͨ��ѧ��ĿIDɾ����Ŀ

	/**
	 * ���¿�Ŀ����
	 * 
	 * @param subjectNewName
	 *            ��Ŀ����
	 * @param subjectId
	 *            ��Ŀ���
	 * @return �Ƿ���³ɹ�
	 */
	public boolean updateSubjectById(String subjectNewName, int subjectId);// ͨ��ѧ��id������Ϣ

	/**
	 * ͨ����Ŀid���ҿ�Ŀ
	 * 
	 * @param subjectId
	 *            ��Ŀ���
	 * @return ���ط��ϸÿ�Ŀ��ŵĿ�Ŀ��Ϣ
	 */
	public Subject findSubjectById(int subjectId);// ͨ����Ŀid���ҿ�Ŀ

	/**
	 * �������еĿ�Ŀ��Ϣ
	 * 
	 * @return �������еĿ�Ŀ��Ϣ
	 */
	public List<Subject> findAllSubject();

}
