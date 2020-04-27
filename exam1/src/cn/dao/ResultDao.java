package cn.dao;

import java.util.List;

import cn.bean.Result;
import cn.bean.Student;

public interface ResultDao {
	/**
	 * ���һ�����Լ�¼
	 * 
	 * @param result
	 *            ���Լ�¼
	 * @return�����Ƿ���ӳɹ�
	 */
	public boolean doResult(Result result);// ���һ����¼

	/**
	 * ����ѧ����ţ����Ա�ţ��༶��ţ���Ŀ���
	 * 
	 * @param studentId
	 *            ѧ�����
	 * @param resultSerialId
	 *            ���Ա��
	 * @param classesId
	 *            �༶���
	 * @param subjectId
	 *            ��Ŀ���
	 * @return ���ط��ϵ�ѧ���ɼ�
	 */
	public List<Result> findResult(int studentId, int resultSerialId, int classesId, int subjectId);// ����studentId��SerialId��ѯ�ɼ�

	/**
	 * ��ѯ����ѧ�����гɼ�
	 * 
	 * @return �������е�ѧ���ĳɼ���Ϣ
	 */
	public List<Result> findAllResult();// ��ѯ����ѧ�����гɼ�

}
