package cn.dao;

import cn.bean.Manager;

public interface ManagerDao {
	/**
	 * 根据ManagerId查找管理员
	 * 
	 * @param id
	 *            管理员编号
	 * @return 返回该id的管理员信息
	 */
	public Manager findManagerById(int id); // 根据Id查找管理员

	/**
	 * 根据Id修改新密码
	 * 
	 * @param id
	 *            管理员编号
	 * @param newPwd
	 *            输入的新密码
	 * @return
	 */
	public boolean updatePwd(int id, String newPwd); // 根据Id修改新密码

}