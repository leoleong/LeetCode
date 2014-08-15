/**
 * Problem:
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 			5
 * 		   / \
 * 		  4	  8
 * 		 /	 / \
 * 		11	13	4
 * 	   / \		 \
 * 	  7	  2		  1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 	
 */
package tree.recursion;

public class PathSum {

	public static void main(String[] args) {

	}

	public static boolean hasPathSum(TreeNode root, int sum) {

		// terminal condition
		if (root == null) {
			return false;
		}
		// convergence condition
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}

		// divide & conquer
		boolean left = hasPathSum(root.left, sum - root.val);
		boolean right = hasPathSum(root.right, sum - root.val);

		return left || right;
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
