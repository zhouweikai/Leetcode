package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllPermuPar {
	/**
	 23'27''， 没有 debug 出来，gg
	 need a deque to keep track of the previous left part, when we
	 want to insert a right part, we have to match the left part on
	 top of deque
	 */
	public List<String> validParentheses(int l, int m, int n) {
		List<String> res = new ArrayList<>();
		int len = 2 * (l + m + n);
		helper(len, new int[] {l, l, m, m, n, n},
				res, new StringBuilder(), new ArrayDeque<>());
		return res;
	}

	private void helper(int len, int[] rem, List<String> res,
						StringBuilder builder, Deque<Character> deque) {
		if (builder.length() == len) {
			res.add(builder.toString());
			return;
		}
		if (rem[0] > 0) {
			builder.append('(');
			deque.offerFirst('(');
			rem[0]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.pollFirst();
			rem[0]++;
		}
		if (rem[2] > 0) {
			builder.append('<');
			deque.offerFirst('<');
			rem[2]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.pollFirst();
			rem[2]++;
		}
		if (rem[4] > 0) {
			builder.append('{');
			deque.offerFirst('{');
			rem[4]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.pollFirst();
			rem[4]++;
		}
		if (!deque.isEmpty() && deque.peekFirst() == '(') {
			builder.append(')');
			deque.pollFirst();
			rem[1]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.offerFirst('(');
			rem[1]++;
		}
		if (!deque.isEmpty() && deque.peekFirst() == '<') {
			builder.append('>');
			deque.pollFirst();
			rem[3]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.offerFirst('<');
			rem[3]++;
		}
		if (!deque.isEmpty() && deque.peekFirst() == '{') {
			builder.append('}');
			deque.pollFirst();
			rem[5]--;
			helper(len, rem, res, builder, deque);
			builder.deleteCharAt(builder.length() - 1);
			deque.offerFirst('{');
			rem[5]++;
		}
	}

	public static void main(String[] args) {
		AllPermuPar allPermuPar = new AllPermuPar();
		List<String> res = allPermuPar.validParentheses(1, 0, 2);
		System.out.println(res);
	}
}