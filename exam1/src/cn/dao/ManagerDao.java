package cn.dao;

import cn.bean.Manager;

public interface ManagerDao {
	/**
	 * ����ManagerId���ҹ���Ա
	 * 
	 * @param id
	 *            ����Ա���
	 * @return ���ظ�id�Ĺ���Ա��Ϣ
	 */
	public Manager findManagerById(int id); // ����Id���ҹ���Ա

	/**
	 * ����Id�޸�������
	 * 
	 * @param id
	 *            ����Ա���
	 * @param newPwd
	 *            �����������
	 * @return
	 */
	public boolean updatePwd(int id, String newPwd); // ����Id�޸�������

}