package tree.recursion;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {

	}

	public static void connect(TreeLinkNode root) {

		connect(root, null);
	}

	// ---------------------------------------------------------------------------
	private static void connect(TreeLinkNode root, TreeLinkNode sibling) {

		// terminal condition
		if (root == null) {
			return;
		} else {
			root.next = sibling;
		}

		connect(root.left, root.right);

		if (sibling == null) {
			connect(root.right, null);
		} else {
			connect(root.right, sibling.left);
		}
	}

	// ------------------------------------------------------------------------------
	// better than connect because of its logic
	public static void connect_1(TreeLinkNode root) {

		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
			root.right.next = root.next == null ? null : root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}

	// ------------------------------------------------------------------------------
	// Definition for binary tree with next pointer.
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
