package cn.dao.impl;

import java.util.ArrayList;

import java.util.List;

import cn.bean.Manager;
import cn.dao.ManagerDao;
import cn.dbc.BaseDao;

public class ManagerDaoImpl implements ManagerDao{

	BaseDao bs = new BaseDao();
	
	@Override
	public Manager findManagerById(int id) {
		Manager manager = null;
		String sql = "SELECT * FROM manager WHERE managerId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(id);
		List<Manager> list = bs.query(sql, lp, Manager.class);
		if (list.size() > 0) { //判断查询结果是否为空
			manager = (Manager)list.get(0);
		}
		return manager;
	}

	@Override
	public boolean updatePwd(int id, String newPwd) {
		boolean isFlag = false;
		String sql = "UPDATE manager SET managerPassword = ? WHERE managerId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(newPwd);
		lp.add(id);
		isFlag = bs.update(sql, lp);
		return isFlag;
	}
	

}
