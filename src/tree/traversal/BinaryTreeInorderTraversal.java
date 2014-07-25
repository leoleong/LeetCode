package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

	}

	// ------------------------------------------------------------------------
	// 1. recursion method
	public static List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		dfs(result, root);
		return result;
	}

	private static void dfs(List<Integer> result, TreeNode node) {

		if (node == null) {
			return;
		}
		dfs(result, node.left);
		result.add(node.val);
		dfs(result, node.right);
	}

	// ------------------------------------------------------------------------
	// 2. stack method
	public static List<Integer> inorderTraversal_1(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}

		return result;
	}

	// ------------------------------------------------------------------------
	// 3. morris method
	public static List<Integer> inorderTraversal_2(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		TreeNode cur, node;
		cur = root;

		while (cur != null) {
			if (cur.left == null) {
				result.add(cur.val);
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
					result.add(cur.val);
					node.right = null;
					cur = cur.right;
				}
			}
		}

		return result;
	}

	// ------------------------------------------------------------------------
	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
