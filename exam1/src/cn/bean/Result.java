package cn.bean;
/**
 * 学生分数表
 * @author 赵敏敏
 *
 */
public class Result {

	/**学生成绩编号*/
	private int resultStudentId;
	/**考试场次编号*/
	private int resultSerialId;
	/**考试分数*/
	private double resultScore;
	/**考试科目*/
	private int subjectId;
	/**学生所属班级*/
	private int classesId;

	public Result() {
		super();
	}

	public Result(int resultStudentId, int resultSerialId, double resultScore, int subjectId, int classesId) {
		super();
		this.resultStudentId = resultStudentId;
		this.resultSerialId = resultSerialId;
		this.resultScore = resultScore;
		this.subjectId = subjectId;
		this.classesId = classesId;
	}

	public int getResultStudentId() {
		return resultStudentId;
	}

	public void setResultStudentId(int resultStudentId) {
		this.resultStudentId = resultStudentId;
	}

	public int getResultSerialId() {
		return resultSerialId;
	}

	public void setResultSerialId(int resultSerialId) {
		this.resultSerialId = resultSerialId;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public int getClassesId() {
		return classesId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}

	@Override
	public String toString() {
		return "Result [resultStudentId=" + resultStudentId + ", resultSerialId=" + resultSerialId + ", resultScore="
				+ resultScore + ", subjectId=" + subjectId + ", classesId=" + classesId + "]";
	}

}
