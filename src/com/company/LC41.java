package com.company;

public class LC41 {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] <= nums.length && nums[i] >= 1 && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		LC41 lc41 = new LC41();
		int[] nums = new int[]{1, 2, 0};
		int[] nums2 = new int[]{3, 4, -1, 1};
		int[] nums3 = new int[]{7, 8, 9, 11, 12};
		lc41.firstMissingPositive(nums3);
	}
}
