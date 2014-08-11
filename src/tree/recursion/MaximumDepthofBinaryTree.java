/**
 * Problem:
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package tree.recursion;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		// divide
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		// conquer
		int depth = Math.max(left, right) + 1; 
		
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
