package linkedlist;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode dummy = new RandomListNode(-1);
		dummy.next = head;
		RandomListNode cur = head;

		while (head != null) {
			cur = new RandomListNode(head.label);
			cur.next = head.next;
			head.next = cur;
			head = cur.next;
		}

		head = dummy.next;
		while (head != null) {
			if (head.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}

		head = dummy.next;
		cur = dummy;
		while (head != null) {
			cur.next = head.next;
			cur = cur.next;
			head.next = cur.next;
			head = head.next;
		}

		return dummy.next;
	}

	// Definition for singly-linked list with a random pointer.
	public static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
}
