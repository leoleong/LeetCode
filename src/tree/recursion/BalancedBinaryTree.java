/**
 * Problem:
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
package tree.recursion;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public static boolean isBalanced(TreeNode root) {

		return balancedHeight(root) >= 0;
	}

	private static int balancedHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		// divide
		int left = balancedHeight(root.left);
		int right = balancedHeight(root.right);

		// conquer
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return -1;
		}
		int height = Math.max(left, right) + 1;

		return height;
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
