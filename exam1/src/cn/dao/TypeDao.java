package cn.dao;

import java.util.List;

import cn.bean.Type;

public interface TypeDao {

	/**
	 * �������ͱ�Ų���������Ϣ
	 * 
	 * @param typeiId
	 *            ���ͱ��
	 * @return ���ظ����ͱ�ŵ���Ϣ
	 */
	public Type findTypeById(int typeiId);

	/**
	 * �������е�������Ϣ
	 * 
	 * @return ��������������Ϣ
	 */
	public List<Type> findAllType();

}
