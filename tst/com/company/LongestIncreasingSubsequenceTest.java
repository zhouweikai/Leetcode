package com.company;

import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {
	@Test
	public void testLengthOfLIS() {
		LongestIncreasingSubsequence lc = new LongestIncreasingSubsequence();
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		lc.lengthOfLIS(nums);
	}
}
