package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeVerifierTest {

	@Test
	void givenASingleCharacter_WhenVerify_ThenTrue() {
		// Given
		String input = "a";
		boolean expected = true;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void givenTwoDifferentCharacters_WhenVerify_ThenFalse() {
		// Given
		String input = "ab";
		boolean expected = false;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void givenTwoEqualCharacters_WhenVerify_ThenTrue() {
		// Given
		String input = "aa";
		boolean expected = true;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}
	@Test
	void givenThreeCharacters_WhenVerify_ThenTrue() {
		// Given
		String input = "ana";
		boolean expected = true;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}
	@Test
	void givenFourCharacters_WhenVerify_ThenTrue() {
		// Given
		String input = "anna";
		boolean expected = true;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void givenAPhrase_WhenVerify_ThenTrue() {
		// Given
		String input = "a man a plan a canal panama";
		boolean expected = true;
		// When
		boolean actual = PalindromeVerifier.verify(input);
		// Then
		assertEquals(expected, actual);
	}
	// 2) The simplest non-palindrome would be two letters that are not the same.
	// 2.1) Write a test for two letters that are the same

}
