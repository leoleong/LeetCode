package tree.recursion;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public static int minDepth(TreeNode root) {

		return minDepth(root, false);
	}

	private static int minDepth(TreeNode root, boolean hasSibling) {

		// convergence condition
		if (root == null) {
			return hasSibling ? Integer.MAX_VALUE : 0;
		}

		int left = minDepth(root.left, root.right != null);
		int right = minDepth(root.right, root.left != null);

		return Math.min(left, right) + 1;
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
