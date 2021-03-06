package stringcalculator;

public class StringCalculator {
	private int answer;
	
	// constructor
	StringCalculator() {
		answer = 0;
	}
	
	private String get_default_delimiter() {
		return ",";
	}

	private String[] get_number_in_string_form(String number_string, String delimeter) {
		String[] numbers = number_string.split(delimeter, 0);
		return numbers;
	}
	
	private int calculate_sum(String[] operands) {
		answer = 0;
		for(String number: operands) {
			answer += Integer.parseInt(number);
		}
		
		return answer;
	}
	
	public int Add(String numbers) {
		String delimeter = "";
		if(numbers.isEmpty()) {
			return 0;
		}
		delimeter = get_default_delimiter();
		
		String[] operands = get_number_in_string_form(numbers, delimeter);
	
		answer = calculate_sum(operands);
		return answer;
	}
}
