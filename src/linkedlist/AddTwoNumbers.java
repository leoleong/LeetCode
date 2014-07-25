package linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {

		int[] array1 = new int[] { 5 };
		ListNode dummy1 = new ListNode(-1);
		ListNode l1 = dummy1;
		for (int i : array1) {
			l1.next = new ListNode(i);
			l1 = l1.next;
		}
		int[] array2 = new int[] { 5 };
		ListNode dummy2 = new ListNode(-1);
		ListNode l2 = dummy2;
		for (int i : array2) {
			l2.next = new ListNode(i);
			l2 = l2.next;
		}

		ListNode node = addTwoNumbers(dummy1.next, dummy2.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int carry = 0;

		while (l1 != null && l2 != null) {
			cur.next = l1;
			cur = cur.next;
			cur.val = l1.val + l2.val + carry;
			carry = cur.val / 10;
			cur.val = cur.val % 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			cur.next = l1;
			cur = cur.next;
			cur.val = l1.val + carry;
			carry = l1.val / 10;
			cur.val = l1.val % 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			cur.next = l2;
			cur = cur.next;
			cur.val = l2.val + carry;
			carry = l2.val / 10;
			cur.val = l2.val % 10;
			l2 = l2.next;
		}
		if (carry == 1) {
			cur.next = new ListNode(1);
		}

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
