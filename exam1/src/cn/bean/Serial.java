package cn.bean;
/**
 * ������Ϣ
 * @author ������
 *
 */
public class Serial {
	/**���Ա��*/
	private int serialId; 
	/**��������*/
	private String serialName; 
	/**����ʱ��*/
	private String serialTime; 
	/**���Կ�Ŀ*/
	private int subjectId;
	/**�༶���*/
	private int classesId;

	public Serial() {
		super();
	}

	public Serial(String serialName, String serialTime, int subjectId, int classesId) {
		super();
		this.serialName = serialName;
		this.serialTime = serialTime;
		this.subjectId = subjectId;
		this.classesId = classesId;
	}

	public int getSerialId() {
		return serialId;
	}

	public String getSerialName() {
		return serialName;
	}

	public String getSerialTime() {
		return serialTime;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public int getClassesId() {
		return classesId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public void setSerialName(String serialName) {
		this.serialName = serialName;
	}

	public void setSerialTime(String serialTime) {
		this.serialTime = serialTime;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}

	@Override
	public String toString() {
		return "Serial [serialId=" + serialId + ", serialName=" + serialName + ", serialTime=" + serialTime
				+ ", subjectId=" + subjectId + ", classesId=" + classesId + "]";
	}

}
