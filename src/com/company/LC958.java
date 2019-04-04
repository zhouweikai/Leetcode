package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LC958 {
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
