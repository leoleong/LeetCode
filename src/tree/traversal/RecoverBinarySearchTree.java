package tree.traversal;

public class RecoverBinarySearchTree {

	private static TreeNode first, second;
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		root.left = left;
		recoverTree(root);
	}

	public static void recoverTree(TreeNode root) {

		TreeNode prev, cur, node;
		prev = null;
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

		if (prev != null && cur.val < prev.val) {
			if (first == null) {
				first = prev;
				second = cur;
			} else {
				second = cur;
			}
		}
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
