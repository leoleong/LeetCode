package sort;

import java.util.ArrayList;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {

		// special Test Case
		if (lists.size() < 1) {
			return null;
		}

		// functional Test Case
		ListNode l1, l2;
		l1 = lists.get(0);
		for (int i = 1; i <= lists.size() - 1; i++) {
			l2 = lists.get(i);
			l1 = mergeTwoLists(l1, l2);
		}

		return l1;
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 != null ? l1 : l2;

		return dummy.next;
	}

	// Definition for singly-linked list.
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
