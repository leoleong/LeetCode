package tree.traversal;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	public static boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		return isSymmetric(left, right);
	}

	private static boolean isSymmetric(TreeNode left, TreeNode right) {

		// convergence condition
		if (left == null && right == null) {
			return true;
		}
		// pruning condition
		if (left == null || right == null) {
			return false;
		}

		return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
