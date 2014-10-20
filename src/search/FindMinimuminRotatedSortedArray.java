/**
 * Problem:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
package search;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {

		int[] num = new int[] { 2, 1 };
		int result = findMin(num);
		System.out.println(result);
	}

	public static int findMin(int[] num) {
		int start = 0;
		int end = num.length - 1;
		int min = Integer.MAX_VALUE;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num[mid] >= num[start]) {
				// left is sorted
				min = Math.min(min, num[start]);
				start = mid + 1;
			} else {
				// right is sorted
				min = Math.min(min, num[mid]);
				end = mid - 1;
			}
		}

		return min;
	}
}
