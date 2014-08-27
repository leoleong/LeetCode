/**
 * Problem:
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
package linkedlist;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}

		RandomListNode node = head;

		// copy nodes and next pointer
		while (node != null) {
			RandomListNode cur = new RandomListNode(node.label);
			cur.next = node.next;
			node.next = cur;
			node = cur.next;
		}

		// copy random pointer
		node = head;
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}

		// seperate list
		RandomListNode dummy = new RandomListNode(Integer.MIN_VALUE);
		RandomListNode cur = dummy;
		node = head;
		while (node != null) {
			cur.next = node.next;
			cur = cur.next;
			node.next = cur.next;
			node = node.next;
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
