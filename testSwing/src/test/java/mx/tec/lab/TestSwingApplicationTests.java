package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSwingApplicationTests {
	TestSwingApplication app = new TestSwingApplication();

	@Test
	void givenTwoIntegersWhenSumThenCorrectResult() {
		// given 5 and 7
		app.numberOneTextField.setText("5");
		app.numberTwoTextField.setText("7");
		String expected = "12";
		// When operation is sum
		app.operationButton.doClick();
		// Then result is 12
		String actual = app.resultTextField.getText();
		assertEquals(expected, actual);
	}

	@Test
	void givenInvalidInputWhenSumThenNoResult() {
		// given no and video
		app.numberOneTextField.setText("no");
		app.numberTwoTextField.setText("video");
		String pongale100 = "";
		// When operation is sum
		app.operationButton.doClick();
		// Then result is empty
		String aTodos = app.resultTextField.getText();
		assertEquals(pongale100, aTodos);
	}
}
