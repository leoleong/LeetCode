package tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		dfs(result, 1, root);
		Collections.reverse(result);

		return result;
	}

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

	// Definition for binary tree
	private class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
