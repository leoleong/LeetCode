/**
 * Problem:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
package tree.construct;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {

	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		return buildTree(postorder, inorder, 0, postorder.length - 1, 0,
				inorder.length - 1);
	}

	private static TreeNode buildTree(int[] postorder, int[] inorder,
			int postFirst, int postLast, int inFirst, int inLast) {

		// convergence condition
		if (postFirst > postLast || inFirst > inLast) {
			return null;
		}

		// get root node from inorder sequence
		TreeNode root = new TreeNode(postorder[postLast]);
		int inRootPos = inFirst;
		for (int i = inFirst; i <= inLast; i++) {
			if (inorder[i] == root.val) {
				inRootPos = i;
				break;
			}
		}
		// total nodes in right subtree
		int distance = inLast - inRootPos;

		root.left = buildTree(postorder, inorder, postFirst, postLast
				- distance - 1, inFirst, inRootPos - 1);
		root.right = buildTree(postorder, inorder, postFirst - distance,
				postLast - 1, inRootPos + 1, inLast);

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
