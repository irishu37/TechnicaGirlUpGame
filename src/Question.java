
public class Question {

	private String correctAnswer;
	private String[] answers;
	private String questionText;
	private int questionNum;
	
	public Question(int questionNum, String questionText, String[] answers, String correctAnswer) { 
		this.questionNum = questionNum;
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.answers = answers;
	}
	
	public int getQuestionNum() {
		return questionNum;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public String[] getAnswerChoices() {
		return answers;
	}
	
	
}
