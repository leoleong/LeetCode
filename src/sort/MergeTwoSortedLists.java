package sort;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);

		ListNode node = mergeTwoLists(l1, l2);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 != null ? l1 : l2;

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
