package com.company;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		while (n > 0) {
			if ((n & 1) == 0) {
				return false;
			}
			n = n >> 1;
		}
		return true;
	}
}
