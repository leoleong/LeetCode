/**
 * Problem:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 */
package search;

public class SearchInsertPosition {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 3, 5, 6 };
		int result = searchInsert(A, 0);
		System.out.println(result);
	}

	public static int searchInsert(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int pos = 0;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
				pos = start;
			} else if (A[mid] > target) {
				end = mid - 1;
				// a little trick here
				pos = mid;
			} else {
				pos = mid;
				break;
			}
		}

		return pos;
	}
}
