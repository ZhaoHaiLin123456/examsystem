package cn.biz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Question;
import cn.dao.QuestionDao;
import cn.dao.impl.QuestionDaoImpl;
import cn.utils.FileUtil;

/**
 * ���������Զ���������
 */
public class AutoImportQuestion {
	private QuestionDao qDao = new QuestionDaoImpl();
	private String errorMsg = new String("�����ļ���ʽ����");
	private List<Question> list = new ArrayList<>();//����ɹ�д�����ݿ����Ŀ
	
	/**
	 * ���������Ƿ�¼��ɹ�
	 * @param file  �����ļ�
	 * @param subId ���������Ŀ�Ŀ
	 * @return ����ɹ���ʧ�ܵı�־
	 */
	public boolean autoImport(File file, int subId) {
		boolean isFlag = false;
		boolean isError = false;
		
		isError = FileUtil.validateFileFormat(file, subId);
		
		/*
		 * �ж������ļ��Ƿ���ڸ�ʽ����
		 */
		if (isError) {
			//System.out.println("�ļ���ʽ����!");
			return isFlag;
			
		}
		
		List<Question> questions = FileUtil.getQuestions();
		/*for (Question q:questions) {
			System.out.println(q.getQuestionContent());
			System.out.println(q.getQuestionAnswer());
			System.out.println(q.getQuestionSubjectId());
			System.out.println(q.getQuestionTypeId());
		}*/
		
		/*
		 * �����ļ�û�и�ʽ���������£���������
		 */
		if (!questions.isEmpty()) {
			int[] nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = 0;
			}
			StringBuffer sb = new StringBuffer("¼��ʧ�ܵ���Ŀ��:");
			for (int i = 0; i < questions.size(); i++) {
				isFlag = qDao.doQuestion(questions.get(i));
				if (!isFlag) {
					sb.append(i + 1 +" ");
				}else {
					list.add(questions.get(i));
				}
			}
			errorMsg = sb.toString();
		}
		
		for (Question q:list) {
			System.out.println(q.getQuestionContent());
			System.out.println(q.getQuestionAnswer());
			System.out.println(q.getQuestionSubjectId());
			System.out.println(q.getQuestionTypeId());
		}
		return isFlag;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public static void main(String[] args) {
		AutoImportQuestion at = new AutoImportQuestion();
		at.autoImport(new File("E://question.txt"), 2);
	}
}
