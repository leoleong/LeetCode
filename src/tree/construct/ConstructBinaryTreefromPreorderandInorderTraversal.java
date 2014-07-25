package tree.construct;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int preFirst, int preLast, int inFirst, int inLast) {

		// convergence condition
		if (preFirst > preLast || inFirst > inLast) {
			return null;
		}

		// get root node from inorder sequence
		TreeNode root = new TreeNode(preorder[preFirst]);
		int inRootPos = inFirst;
		for (int i = inFirst; i <= inLast; i++) {
			if (inorder[i] == root.val) {
				inRootPos = i;
				break;
			}
		}
		// total nodes in left subtree
		int distance = inRootPos - inFirst;

		root.left = buildTree(preorder, inorder, preFirst + 1, preFirst + distance, inFirst, inRootPos - 1);
		root.right = buildTree(preorder, inorder, preFirst + distance + 1, preLast, inRootPos + 1, inLast);

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
