package cn.bean;

/**
 * �����¼��Ϣ
 */
public class Record {
	/** ѧ����� */
	private int recordStudentId;
	/** ��¼��Ŀ��� */
	private String recordTitleNumber = "";
	/** ��¼���α�� */
	private int recordSerialId;
	/** ��¼ѧ���� */
	private String recordAnswer = "";

	public Record() {
		super();
	}

	public Record(Record_temp rcd_temp) {
		super();
		this.recordStudentId = rcd_temp.getRecordTempStudentId();
		this.recordSerialId = rcd_temp.getRecordTempSerialId();
		for (int i = 0; i < rcd_temp.getRecordTempTitleNumber().length; i++) {
			this.recordTitleNumber += rcd_temp.getRecordTempTitleNumber()[i];
			this.recordTitleNumber += " ";
		}
		for (int i = 0; i < rcd_temp.getRecordTempAnswer().length; i++) {
			this.recordAnswer += rcd_temp.getRecordTempAnswer()[i];
			this.recordAnswer += " ";
		}
	}

	public Record(int recordStudentId, String recordTitleNumber, int recordSerialId, String recordAnswer) {
		super();
		this.recordStudentId = recordStudentId;
		this.recordTitleNumber = recordTitleNumber;
		this.recordSerialId = recordSerialId;
		this.recordAnswer = recordAnswer;
	}

	public int getRecordStudentId() {
		return recordStudentId;
	}

	public void setRecordStudentId(int recordStudentId) {
		this.recordStudentId = recordStudentId;
	}

	public String getRecordTitleNumber() {
		return recordTitleNumber;
	}

	public void setRecordTitleNumber(String recordTitleNumber) {
		this.recordTitleNumber = recordTitleNumber;
	}

	public int getRecordSerialId() {
		return recordSerialId;
	}

	public void setRecordSerialId(int recordSerialId) {
		this.recordSerialId = recordSerialId;
	}

	public String getRecordAnswer() {
		return recordAnswer;
	}

	public void setRecordAnswer(String recordAnswer) {
		this.recordAnswer = recordAnswer;
	}

	@Override
	public String toString() {
		return "Record [recordStudentId=" + recordStudentId + ", recordTitleNumber=" + recordTitleNumber
				+ ", recordSerialId=" + recordSerialId + ", recordAnswer=" + recordAnswer + "]";
	}

}
