package com.company;

public class LC231 {
	public boolean isPowerOfTwo(int n) {
		while (n > 0) {
			if ((n & 1) == 0) {
				return false;
			}
			n = n >> 1;
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
