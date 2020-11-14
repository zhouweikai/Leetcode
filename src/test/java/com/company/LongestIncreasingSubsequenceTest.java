package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
	@Test
	public void testLengthOfLIS() {
		// Arrange
		LongestIncreasingSubsequence lc = new LongestIncreasingSubsequence();
		int[] nums = new int[]{10,9,2,5,3,7,101,18};

		// Act & Assert
		assertEquals(4, lc.lengthOfLIS(nums));
	}
}
