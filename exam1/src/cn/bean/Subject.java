package cn.bean;
/**
 * ���Կ�Ŀ
 * @author ������
 *
 */
public class Subject {
	/**��Ŀ���*/
	private int subjectId; 
	/**��Ŀ����*/
	private String subjectName; 

	public Subject() {
		super();
	}

	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
	

}
