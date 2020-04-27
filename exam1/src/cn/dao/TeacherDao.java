package cn.dao;

import java.util.List;

import cn.bean.Teacher;

public interface TeacherDao {

	/**
	 * ͨ����Ŀ��Ų��ҿ�Ŀ
	 * 
	 * @param id
	 *            ��Ŀ���
	 * @return ���ظÿ�Ŀ��ŵĽ�ʦ
	 */
	public Teacher findTeacherById(int id); // ͨ����Ŀ��Ų��ҿ�Ŀ

	/**
	 * ���һ����ʦ
	 * 
	 * @param tea
	 *            һ����ʦ��Ϣ
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean doTeacher(Teacher tea); // �����ʦ

	/**
	 * ɾ��һ����ʦ
	 * 
	 * @param teaId
	 *            ��ʦ���
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delTeacher(int teaId); // ɾ����ʦ

	/**
	 * �޸Ľ�ʦ�û�����
	 * 
	 * @param teacherId
	 *            ��ʦ���
	 * @param newPwd
	 *            ��ʦ����
	 * @return �Ƿ��޸�����ɹ�
	 */
	public boolean updatePwd(int teacherId, String newPwd); // �޸�����

	/**
	 * ���ݿ�Ŀ��Ų�ѯ��ʦ��Ϣ
	 * 
	 * @param subjectId
	 *            ��Ŀ���
	 * @return �������з��ϸÿ�Ŀ��ŵ����н�ʦ��Ϣ
	 */
	public List<Teacher> findTeacherBySubject(int subjectId);

}