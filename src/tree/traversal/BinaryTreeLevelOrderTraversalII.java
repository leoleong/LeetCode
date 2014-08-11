/**
 * Problem:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 		3
 *	   / \
 *    9  20
 *       / \
 *      15  7
 * return its bottom-up level order traversal as:
 * [
 * 	[15,7],
 * 	[9,20],
 * 	[3]
 * ]
 */
package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

//		dfs(result, 1, root);
		bfs(result, root);
		Collections.reverse(result);

		return result;
	}

	// Method 1: DFS
	private static void dfs(List<List<Integer>> result, int level, TreeNode node) {

		if (node == null) {
			return;
		}

		if (result.size() < level) {
			result.add(new ArrayList<Integer>());
		}
		result.get(level - 1).add(node.val);
		dfs(result, level + 1, node.left);
		dfs(result, level + 1, node.right);
	}

	// Method 2: BFS
	private static void bfs(List<List<Integer>> result, TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(level);
		}
	}

	// Definition for binary tree
	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
