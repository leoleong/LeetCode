/**
 * Problem:
 * Given a linked list and a value x, partition it such that 
 * all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->3->4->5.
 */
package linkedlist;

public class PartitionList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 4, 3, 2, 5, 2 };
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		for (int i : array) {
			prev.next = new ListNode(i);
			prev = prev.next;
		}

		ListNode node = partition(dummy.next, 3);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode partition(ListNode head, int x) {

		ListNode leftDummy = new ListNode(-1);
		ListNode rightDummy = new ListNode(-1);
		ListNode left = leftDummy;
		ListNode right = rightDummy;

		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		left.next = rightDummy.next;
		right.next = null;

		return leftDummy.next;
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
