package cn.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.bean.Subject;
import cn.dao.SubjectDao;
import cn.dao.impl.SubjectDaoImpl;


public class TestSubjectDemo {
	
	SubjectDao subDao = new SubjectDaoImpl();
	
	
	/*
	 *测试连接数据库
	 * */
	 @Test
	   public void test01(){
					   
	   }
	 
	//添加新科目
	 @Test
	 public void test02(){
		 boolean isFlag = false;
		 Subject sub = new Subject("语文");
		 isFlag = subDao.doSubject(sub);
		 if (isFlag) {
			System.out.println("添加成功");
		}
		 
	 }
	 
	 
	//通过学科目ID删除科目
	 
	 @Test
	 public void test03(){
		 boolean isFlag = false;
		 isFlag = subDao.deleteSubjctById(1004);
		 if (isFlag) {
			System.out.println("删除成功");
		}
	 }
	//通过学科id更改信息
	 @Test
	 public void test04(){
		 boolean isFlag = false;
		 isFlag = subDao.updateSubjectById("语文",2);
		 if (isFlag) {
			System.out.println("修改成功");
		}
		 
	 }
		//通过科目id查找科目
	 @Test
	 public void test05(){
		 Subject sub = subDao.findSubjectById(1);
		 System.out.println("对应的是："+sub.getSubjectName());
	 }
	 
}
