package tree.traversal;

public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {

	}

	public static void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}
		
		TreeLinkNode dummy = new TreeLinkNode(-1);
		for (TreeLinkNode cur = root, prev = dummy; cur != null; cur = cur.next) {
			if (cur.left != null) {
				prev.next = cur.left;
				prev = prev.next;
			}
			if (cur.right != null) {
				prev.next = cur.right;
				prev = prev.next;
			}
		}
		connect(dummy.next);
	}

	// Definition for binary tree with next pointer.
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
