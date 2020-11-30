package com.company;

/**
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 */
public class L29 {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean isNegative = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			isNegative = true;
		}
		long newDividend = Math.abs((long) dividend);
		long newDivisor = Math.abs((long) divisor);
		int res = 0;
		while (newDividend >= newDivisor) {
			int shift = 0;
			while (newDividend >= (newDivisor << shift)) {
				shift++;
			}
			newDividend -= newDivisor << (shift - 1);
			res += 1 << (shift - 1);
		}
		return isNegative ? -res : res;
	}
}
