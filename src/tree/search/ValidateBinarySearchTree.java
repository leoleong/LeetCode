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
		
		return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
	}

	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}
