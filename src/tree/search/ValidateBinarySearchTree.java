/**
 * Problem:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 	- The left subtree of a node contains only nodes with keys less than the node's key.
 * 	- The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	- Both the left and right subtrees must also be binary search trees.
 */
package tree.search;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}

	public static boolean isValidBST(TreeNode root) {

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBST(TreeNode root, int lower, int upper) {

		// terminal condition
		if (root == null) {
			return true;
		}
		// pruning condition
		if (root.val <= lower || root.val >= upper) {
			return false;
		}
		
		// divide & conquer
		boolean left = isValidBST(root.left, lower, root.val);
		boolean right = isValidBST(root.right, root.val, upper);

		return left && right;
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
