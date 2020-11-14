package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Find the length of the longest substring T of a given string (consists of lowercase
 * letters only) such that every character in T appears no less than k times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
	// Solution 1: brutal force
	public int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (k == 1) {
			return s.length();
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j >= i; j--) {
				String cur = s.substring(i, j + 1);
				// map contains all the chars in the range we are looking at;
				// set contains all the chars in the range with frequency >= k
				Map<Character, Integer> map = new HashMap<>();
				Set<Character> set = new HashSet<>();
				for (int p = 0; p < cur.length(); p++) {
					map.put(cur.charAt(p), map.getOrDefault(cur.charAt(p), 0) + 1);
					if (map.get(cur.charAt(p)) >= k) {
						set.add(cur.charAt(p));
					}
				}
				if (map.size() == set.size()) {
					res = Math.max(res, cur.length());
				}
			}
		}
		return res;
	}

	// Solution 2: dfs
	public int longestSubstring2(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] array = new int[26];
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a']++;
		}
		boolean valid = true;
		for (int i = 0; i < 26; i++) {
			if (array[i] > 0 && array[i] < k) {
				valid = false;
				break;
			}
		}
		// base case
		// if s is valid, it means the whole string is
		// the longest substring we want
		if (valid) {
			return s.length();
		}
		int res = 0;
		int start = 0, end = 0;
		while (end < s.length()) {
			if (array[s.charAt(end) - 'a'] > 0 && array[s.charAt(end) - 'a'] < k) {
				res = Math.max(res, longestSubstring2(s.substring(start, end), k));
				start = end + 1;
			}
			end++;
		}
		res = Math.max(res, longestSubstring2(s.substring(start), k));
		return res;
	}
}
