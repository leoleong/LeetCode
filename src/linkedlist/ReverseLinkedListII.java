/**
 * Problem:
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
package linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5 };
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		for (int i : array) {
			prev.next = new ListNode(i);
			prev = prev.next;
		}
		
		ListNode node = reverseBetween(dummy.next, 2, 4);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		
		for (int i = 1; i <= m - 1; i++) {
			prev = prev.next;
		}
		
		ListNode tail = prev.next;
		ListNode cur;
		for (int i = m; i < n; i++) {
			cur = tail.next;
			tail.next = cur.next;
			cur.next = prev.next;
			prev.next = cur;
		}
		
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
