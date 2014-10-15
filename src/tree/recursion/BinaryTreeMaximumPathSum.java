/**
 * Problem:
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 		1
 * 	   / \
 *    2   3
 * Return 6.
 */
package tree.recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> result = new ArrayList<Integer>();
		dfs(root, result);

		return result.get(0);
	}

	private static int dfs(TreeNode root, List<Integer> result) {
		if (root == null) {
			return 0;
		}

		// divide
		int left = dfs(root.left, result);
		int right = dfs(root.right, result);

		// conquer
		int sum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		if (sum > result.get(0)) {
			result.set(0, sum);
		}

		return root.val + left > right ? left : right;
	}

	// Definition for binary tree
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
