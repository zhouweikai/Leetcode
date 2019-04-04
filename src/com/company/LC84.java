package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC84 {
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
