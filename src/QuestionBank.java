import java.util.HashMap;
import java.util.Map;

public class QuestionBank {

	private Map<Integer, Question> questionMap;

	public QuestionBank() {
		questionMap = new HashMap<>();
		String[] answers = { "6", "7", "5", "4" };
		questionMap.put(1, new Question(1,
				"___ out of 10 indigenous adolescent girls in Guatemala leave school before age 15", answers, "6"));

		answers[0] = "Fifth";
		answers[1] = "Quarter";
		answers[2] = "Third";
		answers[3] = "Sixth";
		questionMap.put(2,
				new Question(2, "In Malawi, less than a ____ of girls finish primary school", answers, "Quarter"));

		answers[0] = "5";
		answers[1] = "3";
		answers[2] = "7";
		answers[3] = "10";
		questionMap.put(3, new Question(3,
				"The commute to school for girls in Malawi and Guatemala can exceed ___ miles in each direction.",
				answers, "10"));

		answers[0] = "6";
		answers[1] = "10";
		answers[2] = "12";
		answers[3] = "8";
		questionMap.put(4, new Question(4,
				"In many countries, more than half of girls drop out before they reach the ___ grade.", answers, "6"));

		answers[0] = "5%";
		answers[1] = "27%";
		answers[2] = "9%";
		answers[3] = "42%";
		questionMap.put(5,
				new Question(5, "What percentage of girls in Malawi graduate from secondary school?", answers, "9%"));

		answers[0] = "5";
		answers[1] = "10";
		answers[2] = "15";
		answers[3] = "3";
		questionMap.put(6, new Question(6,
				"A prevalent challenge of girls in Malawi is the long commute to school which can exceed ___ miles in each direction",
				answers, "10"));
		
		answers[0] = "21.4";
		answers[1] = "15.9";
		answers[2] = "55.7";
		answers[3] = "32.6";
		questionMap.put(7, new Question(7,
				"In 2015, after Girl Up supporters raised enough funds to donate 550 bicycles to girls in two Malawi villages, "
				+ "adolescent girls’ school attendance in those two communities improved by ____%",
				answers, "21.4"));
	}

	public Question getQuestion(int qNum) {
		return questionMap.get(qNum);
	}

	public int numQuestions() {
		return questionMap.size();
	}
}
