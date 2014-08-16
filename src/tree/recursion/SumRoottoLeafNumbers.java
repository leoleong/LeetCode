/**
 * Problem:
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 		1
 * 	   / \
 * 	  2	  3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
package tree.recursion;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {

	}

	public static int sumNumbers(TreeNode root) {

		return sumNumbers(root, 0);
	}

	private static int sumNumbers(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}

		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}

		int left = sumNumbers(root.left, sum);
		int right = sumNumbers(root.right, sum);
		
		return left + right;
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
