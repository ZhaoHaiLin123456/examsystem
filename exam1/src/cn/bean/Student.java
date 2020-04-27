package cn.bean;
/**
 * ѧ����Ϣ
 */
public class Student {
	/**ѧ�����*/
	private int studentId; 
	/**ѧ������*/
	private String studentName; 
	/**ѧ����¼����*/
	private String studentPassword; 
	/**ѧ���Ա�*/
	private String studentSex; 
	/**ѧ���༶*/
	private int studentClassId; 

	public Student() {
		super();
	}

	public Student(String studentName, String studentPassword, String studentSex, int studentClassId) {
		super();
		this.studentName = studentName;
		this.studentPassword = studentPassword;
		this.studentSex = studentSex;
		this.studentClassId = studentClassId;
	}

	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public int getStudentClassId() {
		return studentClassId;
	}

	public void setStudentClassId(int studentClassId) {
		this.studentClassId = studentClassId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPassword="
				+ studentPassword + ", studentSex=" + studentSex + ", studentClassId=" + studentClassId + "]";
	}

	
}
