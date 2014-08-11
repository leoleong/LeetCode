/**
 * Problem:
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
package tree.recursion;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public static int minDepth(TreeNode root) {

		return minDepth(root, false);
	}

	private static int minDepth(TreeNode root, boolean hasSibling) {

		if (root == null) {
			return hasSibling ? Integer.MAX_VALUE : 0;
		}

		// divide
		int left = minDepth(root.left, root.right != null);
		int right = minDepth(root.right, root.left != null);

		// conquer
		int depth = Math.min(left, right) + 1;

		return depth;
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
