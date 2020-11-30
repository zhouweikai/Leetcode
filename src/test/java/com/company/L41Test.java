package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class L41Test {
	@Test
	public void testFirstMissingPositive() {
		// Arrange
		L41 l41 = new L41();
		int[] nums = new int[]{1, 2, 0};
		int[] nums2 = new int[]{3, 4, -1, 1};
		int[] nums3 = new int[]{7, 8, 9, 11, 12};

		// Act & Assert
		assertEquals(3, l41.firstMissingPositive(nums));
		assertEquals(2, l41.firstMissingPositive(nums2));
		assertEquals(1, l41.firstMissingPositive(nums3));
	}
}
