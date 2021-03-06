package stringcalculator;
import java.util.ArrayList;
import java.util.List;

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
	
	private String get_delimeter_of_any_length(String first_line) {
		String delimeter = "";
		List<String> list=new ArrayList<String>();
		for(int i=2; i<first_line.length(); i++) {
			String temp = "";
			temp += first_line.charAt(i);
			int j=i+1;
			while(j < first_line.length() && first_line.charAt(j) != ']') {
				temp += first_line.charAt(j);
				j++;
			}
			temp += "]";
			i = j;
			list.add(temp);
		}
		for(String x: list) {
			delimeter += x;
			delimeter += "|";
		}
		delimeter = delimeter.substring(0, delimeter.length()-1);
		
		return delimeter;
	}
	
	private int calculate_sum_and_return_negative(String[] operands) throws ArithmeticException {
		answer = 0;
		String negativeNumbers = "";
		for(String number: operands) {
			if(!number.isEmpty()) {
				int temp = Integer.parseInt(number);
				if(temp < 0) {
					negativeNumbers += number;
					negativeNumbers += ",";
				}
				else {
					if(temp <= 1000) {
						answer += temp;						
					}
				}
			}
		}
		
		if(!negativeNumbers.isEmpty()) {
			throw new ArithmeticException("negatives not allowed : " + negativeNumbers);
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
			else {
				delimeter = get_delimeter_of_any_length(first_line);
			}
		}
		else {
			delimeter = get_default_delimiter();			
		}
		
		String[] operands = get_number_in_string_form(numbers, delimeter);
	
		answer = calculate_sum_and_return_negative(operands);

		return answer;
	}
}
