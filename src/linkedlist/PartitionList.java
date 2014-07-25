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

		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode cur1 = dummy1;
		ListNode cur2 = dummy2;
		
		while (head != null) {
			if (head.val < x) {
				cur1.next = head;
				cur1 = cur1.next;
			} else {
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		
		return dummy1.next;
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
