/**
 * Problem:
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
package sort;

public class SortList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 4, 3, 2, 5 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : array) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = sortList(dummy.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode sortList(ListNode head) {

		// convergence condition
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middle = findMiddle(head);

		// divide & conquer
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(middle);
		ListNode node = merge(l1, l2);

		return node;
	}

	private static ListNode findMiddle(ListNode head) {

		// head != null && head.next != null
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;

		return fast;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
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
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
