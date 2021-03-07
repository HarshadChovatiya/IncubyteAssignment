package stringcalculator;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private int answer;
	
	// constructor
	StringCalculator() {
		answer = 0;
	}
	
	private String getDefaultDelimiter() {
		return ",|\n";
	}

	private String[] getNumberInStringForm(String number_string, String delimiter) {
		String[] numbers = number_string.split(delimiter, 0);
		return numbers;
	}
	
	// to handle the case where input is in "//;\n1;2" format
	private String getSingleDelimiterWithoutBrackets(String firstLine) {
		return firstLine.substring(2);
	}
	
	private String getDelimiterOfAnyLength(String firstLine) {
		String delimiter = "";
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
			delimiter += x;
			delimiter += "|";
		}
		delimiter = delimiter.substring(0, delimiter.length()-1);
		
		return delimiter;
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
		String delimiter = "";
		if(numbers.isEmpty()) {
			return 0;
		}
		if(numbers.startsWith("//")) {
			String firstLine = numbers.split("\n")[0];
			numbers = numbers.split("\n")[1];
			
			if(firstLine.charAt(2) != '[') {
				delimiter = getSingleDelimiterWithoutBrackets(firstLine);
			}
			else {
				delimiter = getDelimiterOfAnyLength(firstLine);
			}
		}
		else {
			delimiter = getDefaultDelimiter();			
		}
		
		String[] operands = getNumberInStringForm(numbers, delimiter);
	
		answer = calculateSumAndReturnNegative(operands);

		return answer;
	}
}
