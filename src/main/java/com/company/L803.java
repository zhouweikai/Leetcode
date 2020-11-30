package com.company;

/**

 */


/**
 * https://leetcode.com/problems/bricks-falling-when-hit/
 *
 * You are given an m x n binary grid, where each 1 represents a brick. A brick will not drop if:
 *
 * It is directly connected to the top of the grid, or
 * At least one of its four adjacent bricks will not drop.
 *
 * You are also given an array hits. We will do some erasures sequentially. Each time we want to do
 * the erasure at the location hits[i] = (xi, yi), the brick (if it exists) on that location will
 * disappear, and then some other bricks may drop because of that erasure.
 *
 * Return an array representing the number of bricks that will drop after each erasure in sequence.
 */
public class L803 {
	private final int[][] dirs = new int[][]{ {0,-1},{0,1},{-1,0},{1,0} };

	/**
	 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.
	 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.
	 * Return an array representing the number of bricks that will drop after each erasure in sequence.
	 *
	 * Solution: Reverse Union Find
	 * - Traverse hits array, and mark the brick as 2
	 * - union the remaining bricks with four direction(up, down, left, down), count the bricks that connect with top, that is finally remains.
	 * - reverse traverse hits array, union four direction, current size is need to depend this bricks, num[i] = current - remain - 1;
	 *
	 * @param grid dummy
	 * @param hits dummy
	 * @return dummy
	 */
	public int[] hitBricks(int[][] grid, int[][] hits) {
		int rows = grid.length;
		int cols = grid[0].length;
		UnionFind uf = new UnionFind(rows * cols + 1);
		for (int[] hit : hits) {
			// If we want to smash this specific brick
			if (grid[hit[0]][hit[1]] == 1) {
				grid[hit[0]][hit[1]] = 2;
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					unionNeighbor(i, j, grid, uf);
				}
			}
		}
		int rem = uf.size[uf.root(0)];
		int[] res = new int[hits.length];
		for (int i = hits.length - 1; i >= 0; i--) {
			int[] hit = hits[i];
			if (grid[hit[0]][hit[1]] == 2) {
				unionNeighbor(hit[0], hit[1], grid, uf);
				grid[hit[0]][hit[1]] = 1;
			}
			int newRem = uf.size[uf.root(0)];
			res[i] = newRem - rem > 0 ? newRem - rem - 1 : 0;
			rem = newRem;
		}
		return res;
	}

	private void unionNeighbor(int i, int j, int[][] grid, UnionFind uf) {
		int rows = grid.length;
		int cols = grid[0].length;
		for (int[] dir : dirs) {
			int newI = i + dir[0];
			int newJ = j + dir[1];
			if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && grid[newI][newJ] == 1) {
				uf.union(i * cols + j + 1, newI * cols + newJ + 1);
			}
		}
		// 如果是第一行，与天花板连起来
		if (i == 0) {
			uf.union(i * cols + j + 1, 0);
		}
	}

	private class UnionFind {
		public int[] id;
		public int[] size;
		public int count;

		public UnionFind(int n) {
			count = n;
			id = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public int root(int p) {
			int root = p;
			while (root != id[root]) {
				root = id[root];
			}
			while (p != root) {
				int next = id[p];
				id[p] = root;
				p = next;
			}
			return root;
		}

		public boolean find(int p, int q) {
			return root(p) == root(q);
		}

		public void union(int p, int q) {
			int root_p = root(p);
			int root_q = root(q);
			if (root_p != root_q) {
				count--;
			} else {
				return;
			}
			if (size[root_p] < size[root_q]) {
				id[root_p] = root_q;
				size[root_q] += size[root_p];
			} else {
				id[root_q] = root_p;
				size[root_p] += size[root_q];
			}
		}
	}
}

