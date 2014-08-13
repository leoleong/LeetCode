/**
 * Problem:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 		1
 * 	   / \
 * 	  2   2
 *   / \ / \
 *  3  4 4  3
 * But the following is not:
 * 		1
 * 	   / \
 * 	  2   2
 *     \   \
 *      3   3
 *      
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
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

		// divide & conquer
		boolean symmetricTree = left.val == right.val
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);

		return symmetricTree;
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
