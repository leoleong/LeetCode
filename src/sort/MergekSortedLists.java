/**
 * Problem:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	// Method 1: O(N*logk)
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> heap = new PriorityQueue<>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode node1, ListNode node2) {
						if (node1 == null) {
							return 1;
						} else if (node2 == null) {
							return -1;
						}

						return node1.val - node2.val;
					}
				});
		
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.offer(lists.get(i));
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			cur.next = head;
			cur = cur.next;
			if (head.next != null) {
				heap.offer(head.next);
			}
		}

		return dummy.next;
	}

	// Method 2: Time > O(N*logk)
	public static ListNode mergeKListsUsingMerge2(ArrayList<ListNode> lists) {

		// special Test Case
		if (lists.size() < 1) {
			return null;
		}

		// functional Test Case
		ListNode l1, l2;
		l1 = lists.get(0);
		for (int i = 1; i <= lists.size() - 1; i++) {
			l2 = lists.get(i);
			l1 = mergeTwoLists(l1, l2);
		}

		return l1;
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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
		}
	}
}
