package linkedlist;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

		int[] arrays = new int[] { 1, 2, 3, 4, 5 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arrays) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = removeNthFromEnd(dummy.next, 2);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || n == 0) {
			return head;
		} else {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode cur = dummy;

			while (n > 0) {
				head = head.next;
				--n;
			}
			while (head != null) {
				cur = cur.next;
				head = head.next;
			}
			cur.next = cur.next.next;

			return dummy.next;
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
