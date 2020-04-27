package cn.bean;

import cn.utils.Splitter;

/**
 * ���ڽ���������¼
 */
public class Record_temp {
	/** ��¼ѧ����� */
	private int recordTempStudentId;
	/** ��¼��Ŀ��� */
	private int[] recordTempTitleNumber;
	/** ��¼���α�� */
	private int recordTempSerialId;
	/** ��¼ѧ���� */
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
