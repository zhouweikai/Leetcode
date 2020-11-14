package com.company;

import org.junit.jupiter.api.Test;

import static com.company.ValidateIPAddress.none;
import static org.junit.Assert.assertEquals;

public class ValidateIPAddressTest {
	@Test
	public void testValidIPAddress() {
		// Arrange
		ValidateIPAddress lc = new ValidateIPAddress();
		String IP = "172.16.254.1";

		// Act & Assert
		assertEquals(none, lc.validIPAddress(IP));
	}
}
