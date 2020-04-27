package cn.biz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Question;
import cn.dao.QuestionDao;
import cn.dao.impl.QuestionDaoImpl;
import cn.utils.FileUtil;

/**
 * 此类用于自动导入试题
 */
public class AutoImportQuestion {
	private QuestionDao qDao = new QuestionDaoImpl();
	private String errorMsg = new String("试题文件格式有误");
	private List<Question> list = new ArrayList<>();//保存成功写入数据库的题目
	
	/**
	 * 检验试题是否录入成功
	 * @param file  试题文件
	 * @param subId 试题所属的科目
	 * @return 试题成功与失败的标志
	 */
	public boolean autoImport(File file, int subId) {
		boolean isFlag = false;
		boolean isError = false;
		
		isError = FileUtil.validateFileFormat(file, subId);
		
		/*
		 * 判断试题文件是否存在格式错误
		 */
		if (isError) {
			//System.out.println("文件格式有误!");
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
		 * 试题文件没有格式错误的情况下，导入试题
		 */
		if (!questions.isEmpty()) {
			int[] nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = 0;
			}
			StringBuffer sb = new StringBuffer("录入失败的题目有:");
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
