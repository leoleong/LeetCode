/**
 * Problem:
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 		1
 * 	   / \
 * 	  2   5
 * 	 / \   \
 * 	3   4   6
 * The flattened tree should look like:
 * 	1
 * 	 \
 * 	  2
 * 	   \
 * 		3
 * 		 \
 * 		  4
 * 		   \
 * 			5
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
package tree.traversal;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

	}

	public static void flatten(TreeNode root) {

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
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
