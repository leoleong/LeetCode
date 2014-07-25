package tree.search;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {

		List<TreeNode> result = generateTrees(3);
	}

	public static List<TreeNode> generateTrees(int n) {

		return generate(1, n);
	}

	private static List<TreeNode> generate(int start, int end) {

		List<TreeNode> tree = new ArrayList<TreeNode>();
		if (start > end) {
			tree.add(null);
			return tree;
		}

		for (int k = start; k <= end; k++) {
			List<TreeNode> left = generate(start, k - 1);
			List<TreeNode> right = generate(k + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode node = new TreeNode(k);
					node.left = l;
					node.right = r;
					tree.add(node);
				}
			}
		}

		return tree;
	}

	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}
