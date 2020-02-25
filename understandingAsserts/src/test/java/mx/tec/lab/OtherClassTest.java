package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OtherClassTest {

	@Test
	public void testMultiply() {
		OtherClass oc = new OtherClass();
		try {
			assertNotNull(oc.multiply(4,4), "This should be an integer");
		}catch(IllegalArgumentException e){
			assertEquals("X should be less than 1000", e.getMessage());
		}
	}

	@Test
	public void testMultiply_ExceptionIsThrown() {
		OtherClass oc = new OtherClass();
		try {
			assertNotNull(oc.multiply(10004,4), "This should be an integer");
		}catch(IllegalArgumentException e){
			assertEquals("X should be less than 1000", e.getMessage());
		}
	}


}
