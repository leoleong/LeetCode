package tree.recursion;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {

		// convergence condition
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
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
