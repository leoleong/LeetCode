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

		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
