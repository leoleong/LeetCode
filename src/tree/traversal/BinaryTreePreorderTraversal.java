/**
 * Problem:
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {

	}

	// Method 1: recursion method
	public static List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		dfs(result, root);
		return result;
	}

	private static void dfs(List<Integer> result, TreeNode node) {

		if (node == null) {
			return;
		}

		result.add(node.val);
		dfs(result, node.left);
		dfs(result, node.right);
	}

	// Method 2: stack method, simulate recursion
	public static List<Integer> preorderTraversalWithStack(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}

		return result;
	}

	// Method 3: morris method
	public static List<Integer> preorderTraversalWithMorris(TreeNode root) {

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
					result.add(cur.val);
					node.right = cur;
					cur = cur.left;
				} else {
					node.right = null;
					cur = cur.right;
				}
			}
		}

		return result;
	}

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
