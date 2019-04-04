package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC785 {
	// is graph bipartite
	// use BFS to do
	public boolean isBipartite(int[][] graph) {
		Map<Integer, Integer> visited = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			if (!bfs(i, visited, graph)) {
				return false;
			}
		}
		return true;
	}

	private boolean bfs(int node, Map<Integer, Integer> visited, int[][] graph) {
		if (visited.containsKey(node)) {
			return true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		// mark the current node to either 0 or 1
		visited.put(node, 0);
		while (!q.isEmpty()) {
			Integer cur = q.poll();
			int curColor = visited.get(cur);
			// mark its neighbors to the different color
			int neiColor = curColor == 0 ? 1 : 0;
			for (int nei : graph[cur]) {
				if (!visited.containsKey(nei)) {
					// if hasn't been marked, mark as the different color
					visited.put(nei, neiColor);
					q.offer(nei);
				} else {
					// if it has been visited and mark as an incorrect color, it's false
					if (visited.get(nei) != neiColor) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
