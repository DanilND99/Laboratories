package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator calc = new StringCalculator();
	@Test
	void ifEmptyThenReturn0() {
		//Given
		String input = "";
		int expected = 0;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void ifOneThenReturnOne() {
		//Given
		String input = "1";
		int expected = 1;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void ifOneAndTwoThenReturnThree() {
		//Given
		String input = "1,2";
		int expected = 3;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void ifArrayBiggerThanTwo() {
		//Given
		String input = "1,3,7";
		int expected = 11;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void newLineSeparatorTest() {
		//Given
		String input = "1\n3,7";
		int expected = 11;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void differentDelimeterTest() {
		//Given
		String input = "//;\n1;2";
		int expected = 3;
		//When
		int result = calc.add(input);
		//Then
		assertEquals(expected,result);
	}
	@Test
	void ifNegativeNumberThenIllegalArgumentException() {
		//Given
		String input = "-3";
		String expectedMessage = "negatives not allowed -3"; 
		//When
		try {
			int result = calc.add(input);
			fail("Returned: " + result);
		}catch(IllegalArgumentException e) {
			//Then
			assertEquals(expectedMessage,e.getMessage());
		}
	}
}
