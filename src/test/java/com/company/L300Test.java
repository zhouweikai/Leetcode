package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class L300Test {
	@Test
	public void testLengthOfLIS() {
		// Arrange
		L300 lc = new L300();
		int[] nums = new int[]{10,9,2,5,3,7,101,18};

		// Act & Assert
		assertEquals(4, lc.lengthOfLIS(nums));
	}
}
