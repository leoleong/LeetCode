/**
 * Problem:
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
package search;

public class SearchforaRange {

	public static void main(String[] args) {

		int[] A = new int[] { 5, 7, 7, 8, 8, 10 };
		int[] results = searchRange(A, 3);
		for (int i : results) {
			System.out.print(i + " ");
		}
	}

	public static int[] searchRange(int[] A, int target) {

		int lower, higher;

		lower = searchLowerBound(A, target);
		if (lower == -1) {
			return new int[] { -1, -1 };
		} else {
			higher = searchhigherBound(A, target);
			return new int[] { lower, higher };
		}
	}

	private static int searchLowerBound(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int bound = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				end = mid - 1;
				bound = mid;
			}
		}

		return bound;
	}

	private static int searchhigherBound(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int bound = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
				bound = mid;
			}
		}

		return bound;
	}
}
