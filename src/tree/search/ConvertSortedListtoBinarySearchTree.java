package tree.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {

		int[] arrays = new int[] { 1, 2, 3 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arrays) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		TreeNode tree = sortedListToBST(dummy.next);
		System.out.println(tree.left.val);
		System.out.println(tree.val);
		System.out.println(tree.right.val);
	}

	public static TreeNode sortedListToBST(ListNode head) {

		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(head);

		// inorder traversal
		return sortedListToBST(list, 0, length - 1);
	}

	private static TreeNode sortedListToBST(List<ListNode> list, int start, int end) {

		// convergence condition
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(list, start, mid - 1);
		TreeNode root = new TreeNode(list.get(0).val);
		root.left = left;
		list.set(0, list.get(0).next);
		root.right = sortedListToBST(list, mid + 1, end);

		return root;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
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
