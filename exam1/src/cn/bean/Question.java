package cn.bean;

/**
 * 题库信息
 */
public class Question {

	/** 题目编号 */
	private int questionId;
	/** 题目内容 */
	private String questionContent;
	/** 题目答案 */
	private String questionAnswer;
	/** 题目所属科目 */
	private int questionSubjectId;
	/** 题目类型 */
	private int questionTypeId;

	public Question() {
		super();
	}

	public Question(String questionContent, String questionAnswer, int questionSubjectId, int questionTypeId) {
		super();
		this.questionContent = questionContent;
		this.questionAnswer = questionAnswer;
		this.questionSubjectId = questionSubjectId;
		this.questionTypeId = questionTypeId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionSubjectId() {
		return questionSubjectId;
	}

	public void setQuestionSubjectId(int questionSubjectId) {
		this.questionSubjectId = questionSubjectId;
	}

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionContent=" + questionContent + ", questionAnswer="
				+ questionAnswer + ", questionSubjectId=" + questionSubjectId + ", questionTypeId=" + questionTypeId
				+ "]";
	}

}
