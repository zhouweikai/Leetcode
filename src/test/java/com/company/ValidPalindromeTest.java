package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {
	@Test
	public void testIsPalindrome() {
		// Arrange
		String s = "0P01";
		ValidPalindrome lc = new ValidPalindrome();

		// Act & Assert
		assertTrue(lc.isPalindrome(s));
	}
}
