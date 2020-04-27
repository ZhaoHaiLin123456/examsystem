package cn.dao;

import java.util.List;

import cn.bean.Classes;

public interface ClassesDao {

	/**
	 * ����ClassId��ѯ�༶
	 * 
	 * @param ClassId
	 *            �༶���
	 * @return һ���༶��Ϣ�Ķ���
	 */
	public Classes findClassById(int ClassId);// ����ClassId��ѯ�༶

	/**
	 * ��ѯ���а༶
	 * 
	 * @return ���а༶��Ϣ
	 */
	public List<Classes> findAllClass();// �������а༶

	/**
	 * ����һ���༶
	 * 
	 * @param ClassName
	 *            �༶����
	 * @return �Ƿ�ɹ����һ���༶
	 */
	public boolean doClass(String ClassName);// ����һ���༶

	/**
	 * ɾ��һ���༶
	 * 
	 * @param ClassId
	 *            �༶���
	 * @return �Ƿ�ɹ�ɾ��һ���༶��Ϣ
	 */
	public boolean delClass(int ClassId);// ɾ��һ���༶

	/**
	 * ���İ༶����
	 * 
	 * @param ClassId
	 *            �༶���
	 * @param ClassName
	 *            �༶����
	 * @return �Ƿ���ĳɹ�
	 */
	public boolean updateClass(int ClassId, String ClassName);// ���İ༶����

}
