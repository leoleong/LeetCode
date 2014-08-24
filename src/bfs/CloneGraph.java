/**
 * Problem:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * 
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 	- First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * 	- Second node is labeled as 1. Connect node 1 to node 2.
 * 	- Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * 
 * Visually, the graph looks like the following:
 * 			1
 * 		   / \
 * 		  /	  \
 * 		 0-----2
 * 			  / \
 * 			  \-/
 */
package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

	public static void main(String[] args) {

	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();

		// clone node
		queue.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode current = queue.poll();
			for (UndirectedGraphNode neighbor : current.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					queue.offer(neighbor);
				}
			}
		}

		// clone relation
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode current = queue.poll();
			UndirectedGraphNode clone = map.get(current);
			for (UndirectedGraphNode neighbor : current.neighbors) {
				if (!set.contains(neighbor)) {
					set.add(neighbor);
					queue.offer(neighbor);
				}
				clone.neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
	}

	// Definition for undirected graph.
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
