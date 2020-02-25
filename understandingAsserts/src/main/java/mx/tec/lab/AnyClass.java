package mx.tec.lab;

public class AnyClass {
	public void methodThatShouldThrowException() {
		/*
		 * Deleting the line will also cause a failed test.
		 */
		throw new UnsupportedOperationException("Operation Not Supported.");
		//throw new UnsupportedOperationException("Operation Not Supported");
	}
}
