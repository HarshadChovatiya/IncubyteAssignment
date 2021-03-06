package stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestStringCalculator {
	
	private static StringCalculator string_calc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		string_calc = new StringCalculator();
	}

	@Test
	void test_empty_string() {
		int output = string_calc.Add("");
		assertEquals(0, output);
	}

	@Test
	void test_single_number() {
		int output = string_calc.Add("5");
		assertEquals(5, output);
	}
	
	@Test
	void test_two_numbers_with_default_delimeter() {
		int output = string_calc.Add("5,4");
		assertEquals(9, output);
	}
	
	@Test
	void test_multiple_numbers_with_default_delimeter() {
		int output = string_calc.Add("5,4,3,2,1");
		assertEquals(15, output);
	}
	
}
