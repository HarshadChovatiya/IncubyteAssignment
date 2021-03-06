package stringcalculator;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private int answer;
	
	// constructor
	StringCalculator() {
		answer = 0;
	}
	
	private String getDefaultDelimeter() {
		return ",|\n";
	}

	private String[] getNumberInStringForm(String number_string, String delimeter) {
		String[] numbers = number_string.split(delimeter, 0);
		return numbers;
	}
	
	private String getSingleDelimiterWithoutBrackets(String firstLine) {
		return firstLine.substring(2);
	}
	
	private String getDelimeterOfAnyLength(String firstLine) {
		String delimeter = "";
		List<String> list=new ArrayList<String>();
		for(int i=2; i<firstLine.length(); i++) {
			String temp = "";
			temp += firstLine.charAt(i);
			int j=i+1;
			while(j < firstLine.length() && firstLine.charAt(j) != ']') {
				temp += firstLine.charAt(j);
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
	
	private int calculateSumAndReturnNegative(String[] operands) throws ArithmeticException {
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
			String firstLine = numbers.split("\n")[0];
			numbers = numbers.split("\n")[1];
			
			if(firstLine.charAt(2) != '[') {
				delimeter = getSingleDelimiterWithoutBrackets(firstLine);
			}
			else {
				delimeter = getDelimeterOfAnyLength(firstLine);
			}
		}
		else {
			delimeter = getDefaultDelimeter();			
		}
		
		String[] operands = getNumberInStringForm(numbers, delimeter);
	
		answer = calculateSumAndReturnNegative(operands);

		return answer;
	}
}
