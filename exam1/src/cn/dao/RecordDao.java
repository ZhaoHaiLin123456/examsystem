package cn.dao;

import java.util.List;

import cn.bean.Record;

public interface RecordDao {

	/**
	 * ����ѧ����Ų������д����¼
	 * 
	 * @param stuId
	 *            ѧ�����
	 * @return ���ظ�ѧ����ŵ����д����¼
	 */
	public List<Record> findAllRecordByStuId(int stuId); // ����ѧ��Id�������д����¼

	/**
	 * ���ݳ��β������еĴ����¼
	 * 
	 * @param serialId
	 *            ���Գ��α��
	 * @return ���ط��ϸÿ��Գ��α�ŵ����д����¼
	 */
	public List<Record> findAllRecordBySerialId(int serialId); // ���ݳ��β������д����¼

	/**
	 * ����ѧ����źͿ��Գ��α�Ų�ѯ�����¼
	 * 
	 * @param stuId
	 *            ѧ�����
	 * @param serialId
	 *            ���Գ��α��
	 * @return ���ط��ϸ�ѧ����źͿ��Գ��α�ŵĵ����д����¼
	 */
	public Record findRecordByStuIdAndSerialId(int stuId, int serialId); // ����ѧ��Id�Ϳ��Գ���Id��ѯ�����¼

	/**
	 * ��Ӵ����¼
	 * 
	 * @param record
	 *            һ�������¼����
	 * @return �Ƿ�ɹ����һ�������¼
	 */
	public boolean doRecord(Record record); // ��Ӵ����¼

}
