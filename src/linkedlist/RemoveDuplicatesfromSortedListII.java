package linkedlist;

import java.util.HashMap;

public class RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 3, 4, 4, 5 };
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

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;

		while (head != null) {
			if (map.containsKey(head.val)) {
				int value = map.get(head.val);
				map.put(head.val, ++value);
			} else {
				map.put(head.val, 1);
			}
			head = head.next;
		}

		head = dummy.next;
		while (head != null) {
			if (map.get(head.val) == 1) {
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
