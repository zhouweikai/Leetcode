package com.company;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path
 * from top left to bottom right, which minimizes the sum of all numbers
 * along its path.
 */
public class MinimumPathSum {
	// dp
	public int minPathSum(int[][] grid) {
		// dp[i][j] = min sum from (0,0) to (i,j)
		// dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		int[][] dp = new int[grid.length][grid[0].length];
		// base case
		// 第一行
		for (int j = 0; j < grid[0].length; j++) {
			if (j == 0) {
				dp[0][j] = grid[0][0];
				continue;
			}
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}
		// 第一列
		for (int i = 1; i < grid.length; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		// induction rule
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}

	// dfs
	public int minPathSumDfs(int[][] grid) {
		int[] res = new int[]{Integer.MAX_VALUE};
		dfs(grid, res, 0, 0, grid[0][0]);
		return res[0];
	}

	private void dfs(int[][] grid, int[] res, int i, int j, int curSum) {
		// base case
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			res[0] = Math.min(res[0], curSum);
			return;
		}
		if (i < grid.length && j + 1 < grid[0].length) {
			dfs(grid, res, i, j + 1, curSum + grid[i][j + 1]);
		}
		if (i + 1 < grid.length && j < grid[0].length) {
			dfs(grid, res, i + 1, j, curSum + grid[i + 1][j]);
		}
	}
}
