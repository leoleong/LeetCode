package tree.traversal;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

	}

	public static void flatten(TreeNode root) {

		// convergence condition
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);

		if (root.left == null) {
			return;
		}
		TreeNode node = root.left;
		while (node.right != null) {
			node = node.right;
		}
		node.right = root.right;
		root.right = root.left;
		root.left = null;
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
