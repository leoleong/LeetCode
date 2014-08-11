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
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {

	}

	// Method 1: recursion method
	public static List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		dfs(result, root);
		return result;
	}

	private static void dfs(List<Integer> result, TreeNode node) {

		if (node == null) {
			return;
		}
		
		dfs(result, node.left);
		dfs(result, node.right);
		result.add(node.val);
	}

	// Method 2: stack method, simulate recursion
	public static List<Integer> postorderTraversal1(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

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
