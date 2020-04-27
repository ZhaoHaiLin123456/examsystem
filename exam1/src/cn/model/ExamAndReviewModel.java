package cn.model;

public interface ExamAndReviewModel {

	String serialName = null;
	
	void switchQuestion(int que_num);
	void nextQuestion();
	void lastQuestion();
	
	String getSerialName();
	
	int AmountOfJudge = 20;
	int AmountOfSingle = 20;
	int AmountOfMulti = 20;
	int AmountOfQues = AmountOfJudge+AmountOfSingle+AmountOfMulti;

	int getAmountOfJudge();
	int getAmountOfSingle();
	int getAmountOfMulti();
	int getAmountOfQues();

	int currentQues = 0;
	
	int getCurrentQues();

	void confirm();
	
}
