package com.company;

public class LC300 {
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
		LC300 lc = new LC300();
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		lc.lengthOfLIS(nums);

	}
}
