/**
 * Problem:
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
package linkedlist;

public class RotateList {

	public static void main(String[] args) {

		int[] arrays = new int[] {};
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arrays) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = rotateRight(dummy.next, 0);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int n) {

		if (head == null || head.next == null || n == 0) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode tail = dummy;
		int length = 0;

		while (head != null) {
			++length;
			tail = head;
			head = head.next;
		}
		n = length - n % length;

		for (; n > 0; n--) {
			cur = cur.next;
		}
		tail.next = dummy.next;
		dummy.next = cur.next;
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
