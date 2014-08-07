/**
 * Problem:
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
package array;

public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {

		int[] A = { 1, 3 };
		boolean value = search(A, 3);
		System.out.println(value);
	}

	public static boolean search(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == A[mid]) {
				return true;
			}
			if (A[start] == A[mid]) {
				// couldn't judge
				start++;
			} else if (A[start] < A[mid]) {
				// left is sorted
				if (target >= A[start] && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// right is sorted
				if (target <= A[end] && target > A[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return false;
	}
}
