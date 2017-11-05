import java.util.HashMap;
import java.util.Map;

public class QuestionBank {

	private Map<Integer, Question> questionMap;

	public QuestionBank() {
		questionMap = new HashMap<>();
		String[] answers = { "6", "7", "5", "4" };
		questionMap.put(1, new Question(1,
				"___ out of 10 indigenous adolescent girls in Guatemala leave school before age 15", answers, "6"));

		answers = new String[4];
		answers[0] = "Fifth";
		answers[1] = "Quarter";
		answers[2] = "Third";
		answers[3] = "Sixth";
		questionMap.put(2,
				new Question(2, "In Malawi, less than a ____ of girls finish primary school", answers, "Quarter"));

		answers = new String[4];
		answers[0] = "5";
		answers[1] = "3";
		answers[2] = "7";
		answers[3] = "10";
		questionMap.put(3, new Question(3,
				"The commute to school for girls in Malawi and Guatemala can exceed ___ miles in each direction.",
				answers, "10"));

		answers = new String[4];
		answers[0] = "6";
		answers[1] = "10";
		answers[2] = "12";
		answers[3] = "8";
		questionMap.put(4, new Question(4,
				"In many countries, more than half of girls drop out before they reach the ___ grade.", answers, "6"));

		answers = new String[4];
		answers[0] = "5%";
		answers[1] = "27%";
		answers[2] = "9%";
		answers[3] = "42%";
		questionMap.put(5,
				new Question(5, "What percentage of girls in Malawi graduate from secondary school?", answers, "9%"));

		answers = new String[4];
		answers[0] = "5";
		answers[1] = "10";
		answers[2] = "15";
		answers[3] = "3";
		questionMap.put(6, new Question(6,
				"A prevalent challenge of girls in Malawi is the long commute to school which can exceed ___ miles in each direction",
				answers, "10"));

		answers = new String[4];
		answers[0] = "21.4";
		answers[1] = "15.9";
		answers[2] = "55.7";
		answers[3] = "32.6";
		questionMap.put(7, new Question(7,
				"In 2015, after Girl Up supporters raised enough funds to donate 550 bicycles to girls in two Malawi villages, "
						+ "adolescent girls’ school attendance in those two communities improved by ____%",
				answers, "21.4"));

		answers = new String[4];
		answers[0] = "400";
		answers[1] = "250";
		answers[2] = "350";
		answers[3] = "175";
		questionMap.put(8, new Question(8,
				"In 2015, Girl Up expanded SchoolCycle to Guatemala and raised enough money for ___ bicycles.",
				answers, "250"));
		
		answers = new String[4];
		answers[0] = "80 million";
		answers[1] = "100 million";
		answers[2] = "120 million";
		answers[3] = "150 million";
		questionMap.put(9, new Question(9,
				"In a single year, an estimated _________ girls are victims of sexual violence.",
				answers, "150 million"));
		
		answers = new String[4];
		answers[0] = "a lack of teachers";
		answers[1] = "poor infrastructure";
		answers[2] = "early marriage";
		answers[3] = "all of the above";
		questionMap.put(10, new Question(10,
				"Poverty, the main factor preventing girls from staying in school, is linked to what?",
				answers, "all of the above"));
		
		answers = new String[4];
		answers[0] = "35 million";
		answers[1] = "65 million";
		answers[2] = "40 million";
		answers[3] = "75 million";
		questionMap.put(11, new Question(11,
				"Globally, ________ girls are not in school",
				answers, "65 million"));
		
		answers = new String[4];
		answers[0] = "15 million";
		answers[1] = "23 million";
		answers[2] = "33 million";
		answers[3] = "40 million";
		questionMap.put(12, new Question(12,
				"There are _______ fewer girls than boys in primary school ",
				answers, "33 million"));
		
		answers = new String[4];
		answers[0] = "5";
		answers[1] = "10";
		answers[2] = "20";
		answers[3] = "25";
		questionMap.put(13, new Question(13,
				"A girl with an extra year of education can earn ___ percent more as an adult",
				answers, "20"));
		
		answers = new String[4];
		answers[0] = "20";
		answers[1] = "30";
		answers[2] = "40";
		answers[3] = "50";
		questionMap.put(14, new Question(14,
				"A child born to a mother who can read and write is ___ percent more likely to survive past the age of 5",
				answers, "50"));
		
		answers = new String[4];
		answers[0] = "10 million";
		answers[1] = "13 million";
		answers[2] = "17 million";
		answers[3] = "20 million";
		questionMap.put(15, new Question(15,
				"There are 31 million girls of primary school age not in school. "
				+ "_________ of these girls will probably never attend school in their lifetimes.",
				answers, "17 million"));
		
		answers = new String[4];
		answers[0] = "$32 million";
		answers[1] = "$67 million";
		answers[2] = "$4.2 billion";
		answers[3] = "$5.5 billion";
		questionMap.put(16, new Question(16,
				"If India enrolled 1% more girls in secondary school, their GDP would rise by _______",
				answers, "5.5 billion"));
		
		answers = new String[4];
		answers[0] = "5 million";
		answers[1] = "9 million";
		answers[2] = "14 million";
		answers[3] = "18 million";
		questionMap.put(17, new Question(17,
				"_________ girls under 18 will be married this year",
				answers, "14 million"));
		
		answers = new String[4];
		answers[0] = "disease";
		answers[1] = "childbirth";
		answers[2] = "malnutrition";
		answers[3] = "mental health and injuries";
		questionMap.put(18, new Question(18,
				"The #1 cause of death for girls 15-19 is _________",
				answers, "childbirth"));
		
		answers = new String[4];
		answers[0] = "2.6 million";
		answers[1] = "3.0 million";
		answers[2] = "3.2 million";
		answers[3] = "3.6 million";
		questionMap.put(19, new Question(19,
				"If all women in low and lower middle income countries completed secondary education, "
				+ "___________ lives of children under five would be saved every year",
				answers, "3.0 million"));
		
		answers = new String[4];
		answers[0] = "50 percent";
		answers[1] = "65 percent";
		answers[2] = "70 percent";
		answers[3] = "75 percent";
		questionMap.put(20, new Question(20,
				"If all women in sub-Saharan Africa completed their primary education, maternal mortality would fall by _______",
				answers, "70 percent"));
		
		
		

	}

	public Question getQuestion(int qNum) {
		return questionMap.get(qNum);
	}

	public int numQuestions() {
		return questionMap.size();
	}
}
