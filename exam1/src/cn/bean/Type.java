package cn.bean;

/**
 * 题目类型信息
 */
public class Type {

	/** 题目类型编号 */
	private int typeId;
	/** 题目类型名称 */
	private String typeName;

	/**
	 * 创建一个Type对象
	 */
	public Type() {
		super();
	}

	/**
	 * 创建一个Type对象 
	 * @param typeName题目类型名称
	 */
	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}
	/**
	 *
	 * @return返回类型编号
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * 
	 * @param typeId类型编号
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/** @return 返回题目类型名字*/
	public String getTypeName() {
		return typeName;
	}

	/** @param typeName题目类型名字*/
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/** 输出题目类型信息*/
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
