/**
 * Problem:
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
package tree.traversal;

public class SameTree {

	public static void main(String[] args) {

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		// convergence condition
		if (p == null && q == null) {
			return true;
		}
		// pruning condition
		if (p == null || q == null) {
			return false;
		}

		// divide
		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		// conquer
		boolean sameTree = p.val == q.val && left && right;

		return sameTree;
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
