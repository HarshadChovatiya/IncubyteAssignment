package stringcalculator;

public class StringCalculator {
	private int answer;
	
	// constructor
	StringCalculator() {
		answer = 0;
	}
	
	private String get_default_delimiter() {
		return ",|\n";
	}

	private String[] get_number_in_string_form(String number_string, String delimeter) {
		String[] numbers = number_string.split(delimeter, 0);
		return numbers;
	}
	
	private String get_single_delimiter_without_brackets(String first_line) {
		return first_line.substring(2);
	}
	
	private int calculate_sum(String[] operands) {
		answer = 0;
		for(String number: operands) {
			if(!number.isEmpty()) {
				answer += Integer.parseInt(number);				
			}
		}
		
		return answer;
	}
	
	public int Add(String numbers) {
		String delimeter = "";
		if(numbers.isEmpty()) {
			return 0;
		}
		if(numbers.startsWith("//")) {
			String first_line = numbers.split("\n")[0];
			numbers = numbers.split("\n")[1];
			
			if(first_line.charAt(2) != '[') {
				delimeter = get_single_delimiter_without_brackets(first_line);
			}
		}
		else {
			delimeter = get_default_delimiter();			
		}
		
		String[] operands = get_number_in_string_form(numbers, delimeter);
	
		answer = calculate_sum(operands);
		return answer;
	}
}
