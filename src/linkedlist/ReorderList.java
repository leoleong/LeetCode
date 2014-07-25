package linkedlist;

public class ReorderList {

	public static void main(String[] args) {

	}

	public static void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		} else {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode slow, fast;
			slow = fast = dummy;

			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			fast = slow.next;
			slow.next = null;

			fast = reverse(fast);

			slow = dummy.next;
			ListNode next;
			while (slow.next != null) {
				next = slow.next;
				slow.next = fast;
				fast = fast.next;
				slow.next.next = next;
				slow = next;
			}
			slow.next = fast;
			
			return;
		}
	}

	private static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode prev = head;
			ListNode cur = head.next;
			ListNode next = head.next.next;
			while (cur != null) {
				cur.next = prev;
				prev = cur;
				cur = next;
				if (next != null) {
					next = next.next;
				}
			}
			head.next = null;

			return prev;
		}
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
