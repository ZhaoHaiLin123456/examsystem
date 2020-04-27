package cn.bean;

/**
 * ��Ŀ������Ϣ
 */
public class Type {

	/** ��Ŀ���ͱ�� */
	private int typeId;
	/** ��Ŀ�������� */
	private String typeName;

	/**
	 * ����һ��Type����
	 */
	public Type() {
		super();
	}

	/**
	 * ����һ��Type���� 
	 * @param typeName��Ŀ��������
	 */
	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}
	/**
	 *
	 * @return�������ͱ��
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * 
	 * @param typeId���ͱ��
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/** @return ������Ŀ��������*/
	public String getTypeName() {
		return typeName;
	}

	/** @param typeName��Ŀ��������*/
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/** �����Ŀ������Ϣ*/
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
