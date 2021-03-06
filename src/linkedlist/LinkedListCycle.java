/**
 * Problem:
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
package linkedlist;

public class LinkedListCycle {

	public static void main(String[] args) {

	}

	public static boolean hasCycle(ListNode head) {

		ListNode fast, slow;
		fast = slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}

		return false;
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
