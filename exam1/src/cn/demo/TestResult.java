package cn.demo;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import cn.bean.Result;
import cn.dao.ResultDao;
import cn.dao.impl.ResultDaoImpl;

public class TestResult {

	
	
	@Test
	public void textResult01()
	{
		ResultDao resultDao=new ResultDaoImpl();
		Result result=new Result(3003, 1, 34, 1, 1);
		boolean isFlay=false;
		isFlay=resultDao.doResult(result);
		System.out.println(isFlay);
	}
	
	@Test
	public void textResult02()
	{
		ResultDao resultDao=new ResultDaoImpl();
		List<Object> lp=new ArrayList<Object>();
		//*********************************
		List<Result> result=resultDao.findResult(3001, 1, 1,1);
		System.out.println(result.toString());
	}
	
	@Test 
	public void textResult03() 
	{
		ResultDao resultDao=new ResultDaoImpl();
		List<Result> lr=resultDao.findAllResult();
		for (Result result : lr) {
			System.out.println(result.toString());
		}
	}
}
