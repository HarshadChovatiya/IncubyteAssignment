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
	void test() {
		int output = string_calc.Add("1234");
		assertEquals(0, output);
	}

}
