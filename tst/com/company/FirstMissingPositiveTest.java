package com.company;

import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTest {
	@Test
	public void testFirstMissingPositive() {
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		int[] nums = new int[]{1, 2, 0};
		int[] nums2 = new int[]{3, 4, -1, 1};
		int[] nums3 = new int[]{7, 8, 9, 11, 12};
		firstMissingPositive.firstMissingPositive(nums3);
	}
}
