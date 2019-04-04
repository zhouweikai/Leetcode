package com.company;

public class LC125 {
	public boolean isPalindrome(String s) {
		if (s.isEmpty() || s.length() <= 1) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !isValid(s.charAt(i))) {
				i++;
			}
			while (i < j && !isValid(s.charAt(j))) {
				j--;
			}
			if (i < j && s.charAt(i) != s.charAt(j) &&
					Math.abs(s.charAt(i) - s.charAt(j)) != 32) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private boolean isValid(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "0P";
		LC125 lc = new LC125();
		boolean bl = lc.isPalindrome(s);
		System.out.println(bl);
	}
}
