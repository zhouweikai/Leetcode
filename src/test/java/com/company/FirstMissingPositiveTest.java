package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveTest {
	@Test
	public void testFirstMissingPositive() {
		// Arrange
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		int[] nums = new int[]{1, 2, 0};
		int[] nums2 = new int[]{3, 4, -1, 1};
		int[] nums3 = new int[]{7, 8, 9, 11, 12};

		// Act & Assert
		assertEquals(3, firstMissingPositive.firstMissingPositive(nums));
		assertEquals(2, firstMissingPositive.firstMissingPositive(nums2));
		assertEquals(1, firstMissingPositive.firstMissingPositive(nums3));
	}
}
