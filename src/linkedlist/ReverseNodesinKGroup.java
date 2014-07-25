package linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNodesinKGroup {

	public static void main(String[] args) {

		int[] arrays = new int[] { 1, 2, 3, 4, 5, 6 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arrays) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = reverseKGroup(dummy.next, 6);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy.next;
		ListNode prev = dummy;
		Deque<ListNode> queue = new LinkedList<ListNode>();
		int size = 0;

		while (cur != null) {
			queue.offerLast(cur);
			cur = cur.next;
			++size;
			if (size == k) {
				while (size > 0) {
					prev.next = queue.pollLast();
					--size;
					prev = prev.next;
				}
				prev.next = null;
			}
		}
		if (size > 0) {
			prev.next = queue.pollFirst();
			prev = prev.next;
		}

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
