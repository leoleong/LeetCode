/**
 * Problem:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
package linkedlist;

public class ReorderList {

	public static void main(String[] args) {

	}

	public static void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode middle = findMiddle(head);
		middle = reverse(middle);
		merge(head, middle);
	}

	private static ListNode findMiddle(ListNode head) {

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

	private static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode tail = head;
		ListNode cur;
		while (tail.next != null) {
			cur = tail.next;
			tail.next = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
		}

		return dummy.next;
	}

	private static void merge(ListNode head, ListNode middle) {

		ListNode dummy = new ListNode(-1);

		while (head != null && middle != null) {
			dummy.next = head;
			dummy = dummy.next;
			head = head.next;

			dummy.next = middle;
			dummy = dummy.next;
			middle = middle.next;
		}

		dummy.next = head != null ? head : null;
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
