package cn.dao;

import java.util.List;

import cn.bean.Classes;

public interface ClassesDao {

	/**
	 * 根据ClassId查询班级
	 * 
	 * @param ClassId
	 *            班级编号
	 * @return 一个班级信息的对象
	 */
	public Classes findClassById(int ClassId);// 根据ClassId查询班级

	/**
	 * 查询所有班级
	 * 
	 * @return 所有班级信息
	 */
	public List<Classes> findAllClass();// 根据所有班级

	/**
	 * 增加一个班级
	 * 
	 * @param ClassName
	 *            班级名字
	 * @return 是否成功添加一个班级
	 */
	public boolean doClass(String ClassName);// 增加一个班级

	/**
	 * 删除一个班级
	 * 
	 * @param ClassId
	 *            班级编号
	 * @return 是否成功删除一个班级信息
	 */
	public boolean delClass(int ClassId);// 删除一个班级

	/**
	 * 更改班级名称
	 * 
	 * @param ClassId
	 *            班级编号
	 * @param ClassName
	 *            班级姓名
	 * @return 是否更改成功
	 */
	public boolean updateClass(int ClassId, String ClassName);// 更改班级名称

}
