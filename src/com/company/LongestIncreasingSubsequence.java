package com.company;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest
 * increasing subsequence.
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			System.out.println(tails.toString());
			if (i == size) ++size;
		}
		return size;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lc = new LongestIncreasingSubsequence();
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		lc.lengthOfLIS(nums);

	}
}
