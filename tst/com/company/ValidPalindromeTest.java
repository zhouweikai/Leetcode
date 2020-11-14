package com.company;

import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
	@Test
	public void testIsPalindrome() {
		String s = "0P";
		ValidPalindrome lc = new ValidPalindrome();
		boolean bl = lc.isPalindrome(s);
		assert bl;
	}
}
