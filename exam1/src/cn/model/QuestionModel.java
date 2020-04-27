package cn.model;

import java.util.List;
import java.util.Vector;
import java.util.logging.Handler;

import javax.swing.table.AbstractTableModel;

import cn.bean.Question;
import cn.bean.Student;
import cn.bean.Type;
import cn.biz.AutoImportQuestion;
import cn.dao.QuestionDao;
import cn.dao.SubjectDao;
import cn.dao.TypeDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.QuestionDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dao.impl.TypeDaoImpl;
/**
 * Question��Ϣ��ҳ������ģ��
 */
public class QuestionModel extends AbstractTableModel{
	public Vector rowData,columnNames;
	public QuestionDao questionDao;
	public SubjectDao subjectDao;
	public TypeDao typeDao;
	
	/**
	 * 
	 * @param aq�ɹ�¼���������Ŀ
	 */
	public void  queryQuestionImformation(AutoImportQuestion aq) {
		columnNames=new Vector();
		columnNames.add("�ɹ���¼��");
		columnNames.add("��Ŀ����");
		columnNames.add("��Ŀ����");
		columnNames.add("��������");
		columnNames.add("�����");
		rowData=new Vector();
		
		try {
			int i=1;
			questionDao=new QuestionDaoImpl();
			subjectDao=new SubjectDaoImpl();
			typeDao=new TypeDaoImpl();
			List<Question> questions=aq.getList();
			for (Question question : questions) {
				Vector hang=new Vector();
				hang.add(i++);
				hang.add(subjectDao.findSubjectById(question.getQuestionSubjectId()).getSubjectName());
				hang.add(typeDao.findTypeById(question.getQuestionTypeId()).getTypeName());
				hang.add(question.getQuestionContent());
				hang.add(question.getQuestionAnswer());
		
				rowData.add(hang);
			}
		
		} catch (Exception e) {
			System.out.println("û������");
			e.printStackTrace();
		}
	}
	@Override
	public int getRowCount() {
		
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);	
	}
	
	
	@Override
	public String getColumnName(int arg0) {

		return (String)this.columnNames.get(arg0);
	}

}
