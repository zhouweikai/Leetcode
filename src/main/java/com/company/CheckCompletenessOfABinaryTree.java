package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CheckCompletenessOfABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// check a tree is complete tree
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean foundNull = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur == null) {
					foundNull = true;
					break;
				} else {
					if (foundNull) {
						return false;
					}
					q.offer(cur.left);
					q.offer(cur.right);
				}
			}
		}
		return true;
	}
}
