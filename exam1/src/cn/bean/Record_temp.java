package cn.bean;

import cn.utils.Splitter;

/**
 * 用于界面的做题记录
 */
public class Record_temp {
	/** 记录学生编号 */
	private int recordTempStudentId;
	/** 记录题目编号 */
	private int[] recordTempTitleNumber;
	/** 记录场次编号 */
	private int recordTempSerialId;
	/** 记录学生答案 */
	private String[] recordTempAnswer;

	public Record_temp() {
		super();
	}

	public Record_temp(Record record) {
		super();
		this.recordTempStudentId = record.getRecordStudentId();
		this.recordTempSerialId = record.getRecordSerialId();
		this.recordTempTitleNumber = Splitter.splitToInt(record.getRecordTitleNumber());
		this.recordTempAnswer = Splitter.splitToString(record.getRecordAnswer());
	}

	public Record_temp(int recordTempStudentId, int[] recordTempTitleNumber, int recordTempSerialId,
			String[] recordTempAnswer) {
		super();
		this.recordTempStudentId = recordTempStudentId;
		this.recordTempTitleNumber = recordTempTitleNumber;
		this.recordTempSerialId = recordTempSerialId;
		this.recordTempAnswer = recordTempAnswer;
	}

	public int getRecordTempStudentId() {
		return recordTempStudentId;
	}

	public int[] getRecordTempTitleNumber() {
		return recordTempTitleNumber;
	}

	public int getRecordTempTitleNumber(int k) {
		return recordTempTitleNumber[k];
	}

	public int getRecordTempSerialId() {
		return recordTempSerialId;
	}

	public String[] getRecordTempAnswer() {
		return recordTempAnswer;
	}

	public String getRecordTempAnswer(int k) {
		return recordTempAnswer[k];
	}

	public void setRecordTempStudentId(int recordTempStudentId) {
		this.recordTempStudentId = recordTempStudentId;
	}

	public void setRecordTempTitleNumber(int[] recordTempTitleNumber) {
		this.recordTempTitleNumber = recordTempTitleNumber;
	}

	public void setRecordTempSerialId(int recordTempSerialId) {
		this.recordTempSerialId = recordTempSerialId;
	}

	public void setRecordTempAnswer(String[] recordTempAnswer) {
		this.recordTempAnswer = recordTempAnswer;
	}

	public void setRecordTempAnswer(int k, String answer) {
		this.recordTempAnswer[k] = answer;
	}

}
