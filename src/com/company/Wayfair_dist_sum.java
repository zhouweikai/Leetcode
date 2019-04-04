package com.company;

public class Wayfair_dist_sum {
	public int solution(int[] A) {
		// corner case
		if (A == null || A.length == 0) {
			return Integer.MAX_VALUE;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				max = Math.max(max, A[i] + A[j] + (j - i));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = new int[]{-8, 4, 0, 5, -3, 6};
		Wayfair_dist_sum w1 = new Wayfair_dist_sum();
		int res1 = w1.solution(array);
		System.out.println(res1);
		int[] array2 = new int[]{1, 3, -3};
		int res2 = w1.solution(array2);
		System.out.println(res2);
	}
}
