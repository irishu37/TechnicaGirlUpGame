import java.util.HashMap;
import java.util.Map;

public class QuestionBank {

	private Map<Integer, Question> questionMap;
	
	public QuestionBank() {
		questionMap = new HashMap<>();
		String[] answers = {"6", "7", "5", "4"};
		questionMap.put(1, new Question(1, "___ out of 10 indigenous adolescent girls in Guatemala leave school before age 15", answers, "6"));
		answers[0] = "Fifth";
		answers[1] = "Quarter";
		answers[2] = "Third";
		answers[3] = "Fourth";
		questionMap.put(2, new Question(2, "In Malawi, less than a ____ of girls finish primary school", answers, "sixth"));
		answers[0] = "5";
		answers[1] = "3";
		answers[2] = "7";
		answers[3] = "10";
		questionMap.put(3, new Question(3, "The commute to school for girls in Malawi and Guatemala can exceed ___ miles in each direction."
				, answers, "10"));
		answers[0] = "6";
		answers[1] = "10";
		answers[2] = "12";
		answers[3] = "8";
		questionMap.put(4, new Question(4, "In many countries, more than half of girls drop out before they reach the ___ grade."
				, answers, "6"));
	}
	
	public Question getQuestion(int qNum) {
		return questionMap.get(qNum);
	}
}
