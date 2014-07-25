package linkedlist;

public class SwapNodesinPairs {

	public static void main(String[] args) {

		int[] arrays = new int[] { 1, 2, 3, 4 };
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arrays) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode node = swapPairs(dummy.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = dummy.next;
		ListNode next;
		while (cur != null) {
			next = cur.next;
			if (next == null) {
				break;
			} else {
				cur.next = next.next;
				prev.next = next;
				next.next = cur;
			}
			prev = cur;
			cur = cur.next;
		}

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
