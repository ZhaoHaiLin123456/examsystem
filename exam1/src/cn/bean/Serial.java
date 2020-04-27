package cn.bean;
/**
 * øº≥°–≈œ¢
 * @author ’‘√Ù√Ù
 *
 */
public class Serial {
	/**øº ‘±‡∫≈*/
	private int serialId; 
	/**øº ‘√˚≥∆*/
	private String serialName; 
	/**øº ‘ ±º‰*/
	private String serialTime; 
	/**øº ‘ø∆ƒø*/
	private int subjectId;
	/**∞‡º∂±‡∫≈*/
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
