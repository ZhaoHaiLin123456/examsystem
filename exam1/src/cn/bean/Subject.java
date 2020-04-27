package cn.bean;
/**
 * 考试科目
 * @author 赵敏敏
 *
 */
public class Subject {
	/**科目编号*/
	private int subjectId; 
	/**科目名称*/
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
