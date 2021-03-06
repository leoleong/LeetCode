/**
 * Problem:
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 			5
 * 		   / \
 * 		  4	  8
 * 		 /	 / \
 * 		11	13	4
 * 	   / \	   / \
 * 	  7	  2	  5   1
 * return
 * [
 * 	[5,4,11,2],
 * 	[5,8,4,5]
 * ]		
 */
package tree.recursion;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		pathSum(result, path, root, sum);

		return result;
	}

	private static void pathSum(List<List<Integer>> result, List<Integer> path,
			TreeNode root, int sum) {

		// terminal condition
		if (root == null) {
			return;
		}

		path.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new ArrayList<Integer>(path));
		}
		pathSum(result, path, root.left, sum - root.val);
		pathSum(result, path, root.right, sum - root.val);
		path.remove(path.size() - 1);
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
