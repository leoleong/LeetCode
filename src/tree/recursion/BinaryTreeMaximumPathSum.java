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

public class BinaryTreeMaximumPathSum {

	private static int max;

	public static void main(String[] args) {

	}

	public static int maxPathSum(TreeNode root) {

		max = Integer.MIN_VALUE;
		dfs(root);
		
		return max;
	}

	private static int dfs(TreeNode root) {

		if (root == null) {
			return 0;
		}
		
		// divide
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		// conquer
		int tatalSum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		max = Math.max(max, tatalSum);
		int partialSum = Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;

		return partialSum;
	}

	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
