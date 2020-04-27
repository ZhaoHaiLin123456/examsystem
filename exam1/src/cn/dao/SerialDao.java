package cn.dao;

import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import cn.bean.Serial;

public interface SerialDao {

	/**
	 * ��ӿ��Գ���
	 * 
	 * @param serial
	 *            һ�����Զ���
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean doSerialId(Serial serial);// ���һ���µĿ��Գ���

	/**
	 * ɾ��һ������
	 * 
	 * @param serialId
	 *            ���Գ��α��
	 * @return �Ƿ�ɹ�ɾ��
	 */
	public boolean deleteBySerialId(int serialId);// ɾ��һ��SerialId

	/**
	 * ���ĳ�����Ϣ
	 * 
	 * @param serialId
	 *            ���Գ��α��
	 * @param serialTime
	 *            ���Գ��ο�ʼʱ��
	 * @return �Ƿ�����˳�����Ϣ
	 */
	public boolean updateBySerialId(int serialId, String serialTime);// ���ĳ�����Ϣ

	/**
	 * ���ݳ���Id��ѯ������Ϣ
	 * 
	 * @param serialId
	 *            ���Գ��α��
	 * @return ���س�����Ϣ
	 */
	public Serial findSerialById(int serialId);// ���ݳ���Id��ѯ������Ϣ

	/**
	 * ���ݿ�Ŀ��ѯ����
	 * 
	 * @param subjectId
	 *            ��Ŀ���
	 * @return ���ظÿ�Ŀ��ŵ����г�����Ϣ
	 */
	public List<Serial> findSerialBySubjectId(int subjectId);// ���ݿ�Ŀ��ѯ����

	/**
	 * ���ݰ༶��ѯ���Գ���
	 * 
	 * @param classesId
	 *            �༶���
	 * @return �����Ǹð༶��ŵ����г�����Ϣ
	 */
	public List<Serial> findSerialByClassesId(int classesId);// ���ݰ༶��ѯ���Գ��Σ�1���ж��ٳ����ԣ�

	/**
	 * ��ѯ���п��Գ�����Ϣ
	 * 
	 * @return �������еĳ�����Ϣ
	 */
	public List<Serial> findALLSerial();// ��ѯ���п��Գ�����Ϣ

}
