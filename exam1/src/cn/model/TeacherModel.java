package cn.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.bean.Classes;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.dao.SubjectDao;
import cn.dao.TeacherDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

public class TeacherModel extends AbstractTableModel{
	public Vector rowData,columnNames;
	public SubjectDao subjectDao;
	public TeacherDao teacherDao;
	//查询
		public void queryTeacherImformation(int subjectId)
		{
			columnNames=new Vector();
			columnNames.add("教师工号");
			columnNames.add("教师姓名");
			columnNames.add("性       别");
//			columnNames.add("教师密码");
			columnNames.add("科       目");
		
			//rowData可以存放多行数据
			rowData=new Vector();
//			rowData.add(columnNames);
			try {
				teacherDao=new TeacherDaoImpl();
				subjectDao=new SubjectDaoImpl();
				List<Teacher>  rs=teacherDao.findTeacherBySubject(subjectId);
				for (Teacher tea : rs) {
					Vector hang=new Vector();
					hang.add(tea.getTeacherId());
					hang.add(tea.getTeacherName());
					hang.add(tea.getTeacherSex());
//					hang.add(tea.getTeacherPassword());
					hang.add(subjectDao.findSubjectById(tea.getSubjectId()).getSubjectName());
					rowData.add(hang);
				}
			} catch (Exception e) {
				System.out.println("没有数据");
				e.printStackTrace();
			}
		}
		
		public String[] queryAllSubject()
		{
			int i=0;
			subjectDao=new SubjectDaoImpl();
			List<Subject> ls=subjectDao.findAllSubject();
			String [] strings=new String[ls.size()];
			for (Subject subject : ls) {
				strings[i++]=subject.getSubjectName()+"-"+subject.getSubjectId();
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
