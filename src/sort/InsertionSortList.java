/**
 * Problem:
 * Sort a linked list using insertion sort.
 */
package sort;

public class InsertionSortList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 4, 3, 2, 5 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : array) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = insertionSortList(dummy.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode insertionSortList(ListNode head) {

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode prev, next;

		while (cur != null) {
			next = cur.next;
			prev = findInsertionPosition(dummy, cur.val);
			cur.next = prev.next;
			prev.next = cur;
			cur = next;
		}

		return dummy.next;
	}

	private static ListNode findInsertionPosition(ListNode dummy, int val) {

		ListNode prev, cur;
		prev = cur = dummy;

		while (cur != null && cur.val <= val) {
			prev = cur;
			cur = cur.next;
		}

		return prev;
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
