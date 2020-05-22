package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OddAndEvenEvaluatorTest {
	OddAndEvenEvaluator evaluator = new OddAndEvenEvaluator();
	
	@Test
	void givenA2B2WhenEvaluateThenCEvenDEven() {
		// Given
		double a = 2;
		double b = 2;
		// When
		String result = evaluator.evaluate(a, b);
		// Then
		assertEquals("C is even and D is even, c=4.0 and d=0.0", result);
	}
	@Test
	void givenA1B2WhenEvaluateThenCEvenDEven() {
		// Given
		double a = 1;
		double b = 2;
		// When
		String result = evaluator.evaluate(a, b);
		// Then
		assertEquals("C is odd and D is odd, c=3.0 and d=-1.0", result);
	}
	@Test
	void givenA2B1WhenEvaluateThenCEvenDEven() {
		// Given
		double a = 2;
		double b = 1;
		// When
		String result = evaluator.evaluate(a, b);
		// Then
		assertEquals("C is odd and D is odd, c=3.0 and d=1.0", result);
	}
}
