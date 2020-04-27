package cn.dao;

import java.util.List;

import cn.bean.Question;

public interface QuestionDao {

	/**
	 * 添加一道题目
	 * 
	 * @param question
	 *            录入一条题目对象
	 * @return是否成功添加一道题目
	 */
	public boolean doQuestion(Question question);// 录入一条question

	/**
	 * 根据题目编号查找题目
	 * 
	 * @param questionId
	 *            题目编号
	 * @return返回该题目编号的题目
	 */
	public Question findQuestion(int questionId);// 根据questionId查询题目

	/**
	 * 根据科目编号查找题目
	 * 
	 * @param questionSubjectId
	 *            科目编号
	 * @return返回为该科目编号的所有题目
	 */
	public List<Question> findQuestionBySubjectId(int questionSubjectId);// 根据subjectId查询题目

	/**
	 * 根据科目编号和题目类型编号查询题目
	 * 
	 * @param questionSubjectId
	 *            科目编号
	 * @param questionTypeId
	 *            题目类型编号
	 * @return符合该题目编号和题目类型编号的所有信息
	 */
	public List<Question> findQuestionBySubnType(int questionSubjectId, int questionTypeId);// 根据subjectId和questionTypeId查询题目

	/**
	 * 查询所有题目
	 * 
	 * @return 返回所有的题目
	 */
	public List<Question> findAllQuestion();// 查询所有题目

}
