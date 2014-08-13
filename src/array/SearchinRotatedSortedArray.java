/**
 * Problem:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.	
 */
package array;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

		int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		int index = search(A, 8);
		System.out.println(index);
	}

	public static int search(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target == A[mid]) {
				return mid;
			}
			if (A[start] <= A[mid]) {
				// left is sorted
				if (target < A[mid] && target >= A[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// right is sorted
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}
}
