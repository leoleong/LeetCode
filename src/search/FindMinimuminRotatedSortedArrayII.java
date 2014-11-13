/**
 * Problem:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
package search;

public class FindMinimuminRotatedSortedArrayII {

	public static void main(String[] args) {

		int[] num = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int result = findMin(num);
		System.out.println(result);
	}

	public static int findMin(int[] num) {
		int start = 0;
		int end = num.length - 1;
		int min = Integer.MAX_VALUE;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num[mid] == num[start]) {
				min = Math.min(min, num[start]);
				start++;
			} else if (num[mid] > num[start]) {
				min = Math.min(min, num[start]);
				start = mid + 1;
			} else {
				min = Math.min(min, num[mid]);
				end = mid - 1;
			}
		}

		return min;
	}
}
