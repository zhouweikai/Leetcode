package com.company;

import org.junit.jupiter.api.Test;

import static com.company.L468.none;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class L468Test {
	@Test
	public void testValidIPAddress() {
		// Arrange
		L468 lc = new L468();
		String IP = "172.16.254.1";

		// Act & Assert
		assertEquals(none, lc.validIPAddress(IP));
	}
}
