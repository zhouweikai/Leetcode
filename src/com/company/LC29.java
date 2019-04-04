package com.company;

public class LC29 {
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
