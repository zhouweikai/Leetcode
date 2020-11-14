package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in
 * the histogram.
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int result = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i <= heights.length; i++) {
			int cur = i == heights.length ? 0 : heights[i];
			while (!stack.isEmpty() && heights[stack.peekFirst()] >= cur) {
				int height = heights[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
	}
}
