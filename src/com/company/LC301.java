package com.company;

import java.util.*;

// Remove the minimum number of invalid parentheses in order to
// make the input string valid. Return all possible results.

public class LC301 {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		// sanity check
		if (s == null) {
			return res;
		}
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		// init
		q.offer(s);
		visited.add(s);
		// breadth first search
		boolean found = false;
		while (!q.isEmpty()) {
			// generate
			String cur = q.poll();
			if (isValid(cur)) {
				res.add(cur);
				found = true;
			}
			// if found the first valid one, we don't have to do expanding
			if (found) {
				continue;
			}
			// expand
			for (int i = 0; i < cur.length(); i++) {
				if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
					continue;
				}
				String newString = cur.substring(0, i) + cur.substring(i + 1);
				if (visited.add(newString)) {
					q.offer(newString);
				}
			}
		}
		return res;
	}

	// check if the string is valid
	private boolean isValid(String s) {
		// sanity check
		if (s.length() == 0) {
			return true;
		}
		// logic
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '(' && s.charAt(i) != ')') {
				continue;
			}
			if (left < 0) {
				return false;
			}
			if (s.charAt(i) == '(') {
				left++;
			} else {
				left--;
			}
		}
		return left == 0;
	}
}
