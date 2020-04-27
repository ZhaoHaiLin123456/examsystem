package cn.dao;

import java.util.List;

import cn.bean.Type;

public interface TypeDao {

	/**
	 * 根据类型编号查找类型信息
	 * 
	 * @param typeiId
	 *            类型编号
	 * @return 返回该类型编号的信息
	 */
	public Type findTypeById(int typeiId);

	/**
	 * 查找所有的类型信息
	 * 
	 * @return 返回所有类型信息
	 */
	public List<Type> findAllType();

}
