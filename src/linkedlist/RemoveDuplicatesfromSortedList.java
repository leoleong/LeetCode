package linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 1, 2, 3, 3 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : array) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = deleteDuplicates(dummy.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {

		HashSet<Integer> set = new HashSet<Integer>();
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (head != null) {
			if (!set.contains(head.val)) {
				set.add(head.val);
				cur.next = head;
				cur = cur.next;
			}
			head = head.next;
		}
		cur.next = null;

		return dummy.next;
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
}
