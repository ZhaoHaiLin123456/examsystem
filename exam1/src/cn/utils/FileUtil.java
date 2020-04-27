package cn.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Question;

public class FileUtil {
	private static List<Question> questions;
	
	/**
	 * �ж���Ŀ�ļ���ʽ�Ƿ����
	 * @param file   �����ļ�
	 * @param subId  ��Ŀ����
	 * @return       �����ļ���ʽ��־
	 */
	public static boolean validateFileFormat(File file, int subId) {
		String line = null;
		StringBuffer buffer = new StringBuffer();
		int lineNum = 1;
		boolean isError = false;
		questions = new ArrayList<>();
		Question question = new Question();

		try (Reader reader = new FileReader(file); 
				BufferedReader br = new BufferedReader(reader)) {
			stop:
			while ((line = br.readLine()) != null && !line.equals("����")) {
				switch (lineNum % 4) {
				case 1:
					buffer.append(line);
					break;
				case 2:
					if (!line.startsWith("A")) {
						isError = true;
						break stop;
					}
					buffer.append("\n" + line);
					question.setQuestionContent(buffer.toString());
					break;
				case 3:
					if (!line.startsWith("��:")) {
						isError = true;
						break stop;
					}
					if (line.length() < 5) {
						question.setQuestionTypeId(2);
					} else {
						if (line.endsWith("��ȷ") || line.endsWith("����")) {
							question.setQuestionTypeId(1);
						} else {
							question.setQuestionTypeId(3);
						}
					}
					question.setQuestionAnswer(line.substring(3));
					question.setQuestionSubjectId(subId);
					questions.add(question);
					question = new Question();
					buffer = new StringBuffer();
					break;
				}
				lineNum++;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return isError;
	}

	public static List<Question> getQuestions() {
		return questions;
	}

}
