package cn.bean;
/**
 * 老师信息
 * @author 赵敏敏
 *
 */
public class Teacher {

	/**教师编号*/
	private int teacherId; 
	/**教师姓名*/
	private String teacherName; 
	/**教师登录密码*/
	private String teacherPassword;
	/**教师性别*/
	private String teacherSex; 
	/**教师管理科目*/
	private int subjectId;

	public Teacher() {
		super();
	}

	public Teacher(String teacherName, String teacherPassword, String teacherSex, int subjectId) {
		
		super();
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
		this.teacherSex = teacherSex;
		this.subjectId = subjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherPassword="
				+ teacherPassword + ", teacherSex=" + teacherSex + ", subjectId=" + subjectId + "]";
	}
	
	
	
	

}
