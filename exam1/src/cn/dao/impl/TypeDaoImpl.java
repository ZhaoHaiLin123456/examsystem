package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Type;
import cn.dao.TypeDao;
import cn.dbc.BaseDao;

public class TypeDaoImpl implements TypeDao{

	BaseDao bs = new BaseDao();
	@Override
	public Type findTypeById(int typeiId) {
		Type type=null;
		List<Type> list=new ArrayList<Type>();
		String sql="select * from type where typeId=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(typeiId);
		list=bs.query(sql, lp, Type.class);
		if (list.size()>0) {
			type=list.get(0);
		}
		return type;
	}

	@Override
	public List<Type> findAllType() {
		List<Type> list=new ArrayList<Type>();
		String sql="select * from type";
		List<Object> lp=new ArrayList<Object>();
		list=bs.query(sql, lp, Type.class);
		return list;
	}

}
