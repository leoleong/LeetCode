/**
 * Problem:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
package tree.search;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

	}

	public static TreeNode sortedArrayToBST(int[] num) {

		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private static TreeNode sortedArrayToBST(int[] num, int start, int end) {

		// convergence condition
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);

		return root;
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
