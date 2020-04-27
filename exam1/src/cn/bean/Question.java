package cn.bean;

/**
 * �����Ϣ
 */
public class Question {

	/** ��Ŀ��� */
	private int questionId;
	/** ��Ŀ���� */
	private String questionContent;
	/** ��Ŀ�� */
	private String questionAnswer;
	/** ��Ŀ������Ŀ */
	private int questionSubjectId;
	/** ��Ŀ���� */
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
