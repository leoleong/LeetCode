package tree.recursion;

public class BinaryTreeMaximumPathSum {

	private static int max;

	public static void main(String[] args) {

	}

	public static int maxPathSum(TreeNode root) {

		max = Integer.MIN_VALUE;

		dfs(root);

		return max;
	}

	private static int dfs(TreeNode root) {

		// terminal condition
		if (root == null) {
			return 0;
		}
		
		int left = dfs(root.left);
		int right = dfs(root.right);
		int sum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		max = Math.max(max, sum);

		return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;
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
