package cn.model;
import java.util.List;
import java.util.Vector;

import javax.security.auth.Subject;
import javax.swing.table.AbstractTableModel;

import cn.bean.Classes;
import cn.bean.Result;
import cn.bean.Serial;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.dao.ClassesDao;
import cn.dao.ResultDao;
import cn.dao.SerialDao;
import cn.dao.SubjectDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.SerialDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dbc.BaseDao;

public class ResultModel extends AbstractTableModel{
	public Vector rowData,columnNames;
	public ResultDao resultDao;
	public SubjectDao subjectDao;
	public ClassesDao classDao;
	public SerialDao serialDao;
	
	//查询
	public void queryStudentResult(int studentId,int resultSerialId,int classesId,int subjectId)
	{
		columnNames=new Vector();
		columnNames.add("学生学号");
		columnNames.add("考试场次");
		columnNames.add("考试成绩");
		columnNames.add("考试类型");//根据subjectID查询考试科目
		columnNames.add("考试班级");//根据classesID查询考试科目

		//rowData可以存放多行数据
		rowData=new Vector();
//		rowData.add(columnNames);
		try {
			resultDao=new ResultDaoImpl();
			subjectDao=new SubjectDaoImpl();
			classDao=new ClassesDaoImpl();
			/**
			 * 
			 */
			List<Result> rs=resultDao.findResult(studentId, resultSerialId, classesId,subjectId);
			for (Result result : rs) {
				System.out.println(result.toString());
			}
			for (Result result : rs) {
				Vector hang=new Vector();
				hang.add(result.getResultStudentId());
				hang.add(result.getResultSerialId());
				hang.add(result.getResultScore());
				hang.add(subjectDao.findSubjectById(result.getSubjectId()).getSubjectName());
				hang.add(classDao.findClassById(result.getClassesId()).getClassName());
				//加入到rowData
				rowData.add(hang);
			}
		} catch (Exception e) {
			System.out.println("没有数据");
			e.printStackTrace();	
		}
	}
	public String[] queryStudentSubject()
	{
		int i=0;
		subjectDao=new SubjectDaoImpl();
		List<cn.bean.Subject> ls=subjectDao.findAllSubject();
		String [] strings=new String[ls.size()+1];
		for (cn.bean.Subject subject : ls) {
			strings[i++]=subject.getSubjectName()+"-"+subject.getSubjectId();
		}	
		
		return strings;
	}
	
	public String[] queryAllSerial()
	{
		int i=0;
		serialDao=new SerialDaoImpl();
		List<Serial> ls=serialDao.findALLSerial();
		String [] strings=new String[ls.size()+1];
		for (Serial serial : ls) {
			strings[i++]=serial.getSerialName()+"-"+serial.getSerialId();
		}
		
		return strings;
	}
	
	public String[] queryAllClasses()
	{
		int i=0;
		classDao=new ClassesDaoImpl();
		List<Classes> ls=classDao.findAllClass();
		String [] strings=new String[ls.size()+1];
		for (Classes classes : ls) {
			strings[i++]=classes.getClassName()+"-"+classes.getClassId();
		}
		
		return strings;
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
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(arg0);
	}
	
}
