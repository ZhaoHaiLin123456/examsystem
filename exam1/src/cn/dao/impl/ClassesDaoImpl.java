package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cn.bean.Classes;
import cn.dao.ClassesDao;
import cn.dbc.BaseDao;

public class ClassesDaoImpl implements ClassesDao{

	BaseDao bs=new BaseDao();

	@Override
	public Classes findClassById(int classId) {
		Classes classes=null;
		List<Classes> list=new ArrayList<Classes>();
		String sql="select * from Classes where classId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(classId);
		list=bs.query(sql, lp, Classes.class);
		if (list.size()>0) 
			classes=list.get(0);
		return classes;
	}

	@Override
	public List<Classes> findAllClass() {
		List<Classes> list=null;
		String sql="select * from Classes";
		List<Object> lp=new ArrayList<Object>();
		list =  bs.query(sql, lp, Classes.class);
		return list;
	}

	@Override
	public boolean doClass(String className) {
		String sql="insert into classes(className) values(?)";
		List<Object> lp=new ArrayList<Object>();
		lp.add(className);
		return bs.update(sql, lp);
	}

	@Override
	public boolean delClass(int classId) {
		String sql="delete from classes where classId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(classId);
		return bs.update(sql, lp);
	}

	@Override
	public boolean updateClass(int classId, String className) {
		String sql="update classes set className=? where classId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(className);
		lp.add(classId);
		return bs.update(sql, lp);
	}
	
	

}
