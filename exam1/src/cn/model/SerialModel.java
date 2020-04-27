package cn.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import cn.bean.Classes;
import cn.bean.Serial;
import cn.dao.ClassesDao;
import cn.dao.SerialDao;
import cn.dao.SubjectDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.SerialDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
public class SerialModel extends AbstractTableModel{
	public Vector rowData,columnNames;
	public SerialDao serialDao;
	public SubjectDao subjectDao;
	public ClassesDao classDao;

//	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
//	  tcr.setHorizontalAlignment(JLabel.CENTER);
//	  tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
//	  tabledata.setDefaultRenderer(Object.class, tcr);
	
	
	
	//查询
	public void querySerialImformation(int classesId)
	{
		columnNames=new Vector();
		columnNames.add("场次编号");
		columnNames.add("考试名称");
		columnNames.add("考试时间");
		columnNames.add("科目名称");
		columnNames.add("班级名称");
	
		//rowData可以存放多行数据
		rowData=new Vector();
//		rowData.add(columnNames);
		try {
			serialDao=new SerialDaoImpl();
			subjectDao=new SubjectDaoImpl();
			classDao=new ClassesDaoImpl();
			List<Serial>  rs=serialDao.findSerialByClassesId(classesId);
			for (Serial serial : rs) {
				Vector hang=new Vector();
				hang.add(serial.getSerialId());
				hang.add(serial.getSerialName());
				hang.add(serial.getSerialTime());
				hang.add(subjectDao.findSubjectById(serial.getSubjectId()).getSubjectName());
				hang.add(classDao.findClassById(serial.getClassesId()).getClassName());
				rowData.add(hang);
			}
		} catch (Exception e) {
			System.out.println("没有数据");
			e.printStackTrace();
		}
	}
	
	public String[] queryAllClass()
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
