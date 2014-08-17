/**
 * Problem:
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
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

		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;

		for (; n > 0; n--) {
			head = head.next;
		}
		while (head != null) {
			cur = cur.next;
			head = head.next;
		}
		cur.next = cur.next.next;

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
