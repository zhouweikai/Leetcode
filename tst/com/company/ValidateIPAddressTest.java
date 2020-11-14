package com.company;

import org.junit.jupiter.api.Test;

public class ValidateIPAddressTest {
	@Test
	public void testValidIPAddress() {
		ValidateIPAddress lc = new ValidateIPAddress();
		String IP = "172.16.254.1";
		lc.validIPAddress(IP);
	}
}
