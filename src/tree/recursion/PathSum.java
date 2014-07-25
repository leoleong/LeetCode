package tree.recursion;

public class PathSum {

	public static void main(String[] args) {

	}

	public static boolean hasPathSum(TreeNode root, int sum) {

		// terminal condition
		if (root == null) {
			return false;
		}
		// convergence condition
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
