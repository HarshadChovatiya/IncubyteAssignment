package stringcalculator;

public class StringCalculator {
	private int answer;
	
	// constructor
	StringCalculator() {
		answer = 0;
	}
	
	public int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		return answer;
	}
}
