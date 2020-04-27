package cn.model;

import java.util.List;
import java.util.Vector;

import javax.management.Query;
import javax.swing.table.AbstractTableModel;

import cn.bean.Classes;
import cn.bean.Student;
import cn.dao.ClassesDao;
import cn.dao.ResultDao;
import cn.dao.SerialDao;
import cn.dao.StudentDao;
import cn.dao.SubjectDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;

public class StudentModel extends AbstractTableModel {
	public Vector rowData,columnNames;
	public ClassesDao classDao;
	public StudentDao studentDao;
	//��ѯ
	public void queryStudentImformation(int classId)
	{
		columnNames=new Vector();
		columnNames.add("ѧ��ѧ��");
		columnNames.add("ѧ������");
		columnNames.add("��       ��");
//		columnNames.add("ѧ������");
		columnNames.add("��       ��");
	
		//rowData���Դ�Ŷ�������
		rowData=new Vector();

		try {
			studentDao=new StudentDaoImpl();
			classDao=new ClassesDaoImpl();
			List<Student>  rs=studentDao.findStudentByClassId(classId);//Ĭ������һ��
			for (Student student : rs) {
				Vector hang=new Vector();
				hang.add(student.getStudentId());
				hang.add(student.getStudentName());
				hang.add(student.getStudentSex());
//				hang.add(student.getStudentPassword());
				hang.add(classDao.findClassById(student.getStudentClassId()).getClassName());
				rowData.add(hang);
			}
		} catch (Exception e) {
			System.out.println("û������");
			e.printStackTrace();
		}
	}
	
	public String[] queryAllClass()
	{
		int i=0;
		classDao=new ClassesDaoImpl();
		List<Classes> ls=classDao.findAllClass();
		String [] strings=new String[ls.size()];
		for (Classes classes : ls) {
			strings[i++]=classes.getClassName()+"-"+classes.getClassId();
		}	
		return strings;
		
	}
	//
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
