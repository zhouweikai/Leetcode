package com.company;

public class LC468 {
	private final String v4 = "IPv4";
	private final String v6 = "IPv6";
	private final String none = "Neither";

	public String validIPAddress(String IP) {
		if (isV4(IP)) {
			return v4;
		} else if (isV6(IP)) {
			return v6;
		}
		return none;
	}

	private boolean isV4(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		String[] array = s.split(".");
		if (array.length != 4) {
			return false;
		}
		// 0 - 255, no leading zeros
		for (int i = 0; i < 4; i++) {
			String ss = array[i];
			if (ss.isEmpty()) {
				return false;
			}
			if ((ss.charAt(0) == '0' && ss.length() > 1) || ss.length() > 3) {
				return false;
			}
			for (int j = 0; j < ss.length(); j++) {
				if (!Character.isDigit(ss.charAt(j))) {
					return false;
				}
			}
			if (Integer.valueOf(ss) < 0 || Integer.valueOf(ss) > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean isV6(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		String[] array = s.split(":");
		if (array.length != 8) {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			String ss = array[i];
			if (ss.isEmpty()) {
				return false;
			}
			if (ss.length() > 4) {
				return false;
			}
			for (int j = 0; j < ss.length(); j++) {
				char c = ss.charAt(j);
				if (!Character.isDigit(c) && !(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LC468 lc = new LC468();
		String IP = "172.16.254.1";
		lc.validIPAddress(IP);
	}
}
