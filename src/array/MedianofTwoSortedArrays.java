/**
 * Problem:
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
package array;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 3, 4 };
		int[] B = new int[] { 5, 6, 7, 8 };
		double result = findMedianSortedArrays(A, B);
		System.out.println(result);
	}

	public static double findMedianSortedArrays(int[] A, int[] B) {

		int length = A.length + B.length;
		if (length % 2 == 1) {
			return helper(A, 0, B, 0, length / 2 + 1);
		} else {
			return (helper(A, 0, B, 0, length / 2) + helper(A, 0, B, 0,
					length / 2 + 1)) / 2.0;
		}
	}

	private static int helper(int[] A, int aStart, int[] B, int bStart, int k) {

		// convergence condition
		if (aStart >= A.length) {
			return B[bStart + k - 1];
		}
		if (bStart >= B.length) {
			return A[aStart + k - 1];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}

		int aKey = aStart + k / 2 - 1 < A.length ? A[aStart + k / 2 - 1]
				: Integer.MAX_VALUE;
		int bKey = bStart + k / 2 - 1 < B.length ? B[bStart + k / 2 - 1]
				: Integer.MAX_VALUE;
		if (aKey < bKey) {
			return helper(A, aStart + k / 2, B, bStart, k - k / 2);
		} else {
			return helper(A, aStart, B, bStart + k / 2, k - k / 2);
		}
	}
}
