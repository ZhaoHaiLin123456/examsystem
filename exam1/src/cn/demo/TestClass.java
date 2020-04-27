package cn.demo;

import java.util.List;

import org.junit.Test;

import cn.bean.Classes;
import cn.dao.impl.ClassesDaoImpl;

public class TestClass {
	ClassesDaoImpl cdi = new ClassesDaoImpl();
//	@Test
//	//查一个
//	public void dada() {
//		int a = 2;
//		Classes clazz = cdi.findClassName(a);
//		System.out.println(clazz.getClassName());
//	}
	
	@Test
	//查全部
	public void dada() {
		List<Classes> clazz = cdi.findAllClass();
		System.out.println(clazz.get(1).getClassName());
		
	}
	
//	@Test
//	public void zhengjia () {
//		cdi.doClass("4班");
//	}
	
//	@Test
//	public void shanchu () {
//		cdi.delClass(6);
//	}
		
//	@Test
//	public void gengxin() {
//		System.out.println(cdi.updateClass(3, "4班"));
//	}

}
