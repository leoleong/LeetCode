/**
 * Problem:
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 	 1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 */
package tree.search;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {

	}

	public static List<TreeNode> generateTrees(int n) {

		return generate(1, n);
	}

	private static List<TreeNode> generate(int start, int end) {

		List<TreeNode> result = new ArrayList<TreeNode>();
		
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int k = start; k <= end; k++) {
			List<TreeNode> lefts = generate(start, k - 1);
			List<TreeNode> rights = generate(k + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(k);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}

		return result;
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
