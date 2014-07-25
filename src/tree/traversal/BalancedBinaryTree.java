package tree.traversal;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public static boolean isBalanced(TreeNode root) {

		boolean result = balancedHeight(root) >= 0;
		return result;
	}

	private static int balancedHeight(TreeNode root) {

		// convergence condition
		if (root == null) {
			return 0;
		}

		int left = balancedHeight(root.left);
		int right = balancedHeight(root.right);
		
		if (Math.abs(left - right) > 1 || left < 0 || right < 0) {
			return -1;
		}

		return Math.max(left, right) + 1;
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
