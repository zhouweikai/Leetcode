package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class L125Test {
	@Test
	public void testIsPalindrome() {
		// Arrange
		String s = "0P01";
		L125 lc = new L125();

		// Act & Assert
		assertTrue(lc.isPalindrome(s));
	}
}
