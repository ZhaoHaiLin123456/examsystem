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
	 *�����������ݿ�
	 * */
	 @Test
	   public void test01(){
					   
	   }
	 
	//����¿�Ŀ
	 @Test
	 public void test02(){
		 boolean isFlag = false;
		 Subject sub = new Subject("����");
		 isFlag = subDao.doSubject(sub);
		 if (isFlag) {
			System.out.println("��ӳɹ�");
		}
		 
	 }
	 
	 
	//ͨ��ѧ��ĿIDɾ����Ŀ
	 
	 @Test
	 public void test03(){
		 boolean isFlag = false;
		 isFlag = subDao.deleteSubjctById(1004);
		 if (isFlag) {
			System.out.println("ɾ���ɹ�");
		}
	 }
	//ͨ��ѧ��id������Ϣ
	 @Test
	 public void test04(){
		 boolean isFlag = false;
		 isFlag = subDao.updateSubjectById("����",2);
		 if (isFlag) {
			System.out.println("�޸ĳɹ�");
		}
		 
	 }
		//ͨ����Ŀid���ҿ�Ŀ
	 @Test
	 public void test05(){
		 Subject sub = subDao.findSubjectById(1);
		 System.out.println("��Ӧ���ǣ�"+sub.getSubjectName());
	 }
	 
}
