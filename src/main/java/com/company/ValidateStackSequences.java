package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 */
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int j = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < pushed.length; i++) {
			stack.offerFirst(pushed[i]);
			while (j < popped.length
					&& !stack.isEmpty()
					&& stack.peekFirst() == popped[j]) {
				stack.pollFirst();
				j++;
			}
		}
		return stack.isEmpty();
	}
}
