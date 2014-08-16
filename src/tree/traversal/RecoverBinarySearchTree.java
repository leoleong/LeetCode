/**
 * Problem:
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
package tree.traversal;

public class RecoverBinarySearchTree {

	private static TreeNode first, second;
	private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public static void main(String[] args) {

		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		root.left = left;

		recoverTree(root);
	}

	// Method 1: Recursion Traversal
	public static void recoverTreeInorder(TreeNode root) {

		traversal(root);

		// swap value of first&second
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private static void traversal(TreeNode root) {

		if (root == null) {
			return;
		}

		traversal(root.left);
		check(root, root);
		prev = root;
		traversal(root.right);
	}

	// Method 2: Morris Traversal
	public static void recoverTree(TreeNode root) {

		TreeNode cur, node;
		cur = root;
		first = second = null;

		while (cur != null) {
			if (cur.left == null) {
				check(prev, cur);
				prev = cur;
				cur = cur.right;
			} else {
				// find predecessor
				node = cur.left;
				while (node.right != null && node.right != cur) {
					node = node.right;
				}

				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					check(prev, cur);
					prev = cur;
					cur = cur.right;
					node.right = null;
				}
			}
		}

		// swap value of first&second
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private static void check(TreeNode prev, TreeNode cur) {

		if (cur.val < prev.val) {
			if (first == null) {
				first = prev;
				second = cur;
			} else {
				second = cur;
			}
		}
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
