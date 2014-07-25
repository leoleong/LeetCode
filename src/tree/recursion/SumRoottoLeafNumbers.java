package tree.recursion;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {

	}

	public static int sumNumbers(TreeNode root) {

		return dfs(root, 0);
	}

	private static int dfs(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return sum * 10 + root.val;
		}

		return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
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
