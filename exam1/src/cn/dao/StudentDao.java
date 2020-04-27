package cn.dao;

import java.util.List;

import cn.bean.Student;

public interface StudentDao {
	/**
	 * ����ѧ��
	 * 
	 * @param student
	 *            һ��ѧ��
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean doStudnet(Student student);// ��

	/**
	 * ����ѧ��ѧ��ɾ��һ��ѧ����¼
	 * 
	 * @param studentId
	 *            ѧ�����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStudent(int studentId);// ɾ

	/**
	 * �޸�ѧ������
	 * 
	 * @param studentId
	 *            ѧ�����
	 * @param newPwd
	 *            �����������
	 * @return �Ƿ���³ɹ�
	 */
	public boolean updateStuPwd(int studentId, String newPwd); // ��

	/**
	 * ͨ��ѧ��ѧ�Ų���ѧ��
	 * 
	 * @param studentId
	 *            ѧ�����
	 * @return �����Ǹ�ѧ��ѧ�ŵ�ѧ��
	 */
	public Student findByStudentId(int studentId);// ͨ��ѧ��ѧ�Ų���ѧ��

	/**
	 * ͨ���༶�Ų��Ҷ�Ӧ�༶������ѧ��
	 * 
	 * @param ClassId
	 *            �༶���
	 * @return ���ظð༶��ŵ�����ѧ����Ϣ
	 */
	public List<Student> findStudentByClassId(int ClassId);// ͨ���༶�Ų��Ҷ�Ӧ�༶������ѧ��

}
