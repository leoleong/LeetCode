/**
 * Problem:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, 
 * given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
package dp;

public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 3, -2, 4 };
		int result = maxProductII(A);
		System.out.println(result);
	}

	// Method 1: Sequence DP
	private static int maxProduct(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int[] min = new int[A.length];
		int[] max = new int[A.length];
		min[0] = A[0];
		max[0] = A[0];
		int result = A[0];

		for (int i = 1; i < A.length; i++) {
			min[i] = Math.min(Math.min(min[i - 1] * A[i], A[i]), max[i - 1]
					* A[i]);
			max[i] = Math.max(Math.max(max[i - 1] * A[i], A[i]), min[i - 1]
					* A[i]);
			result = Math.max(result, max[i]);
		}

		return result;
	}

	// Method 2: Single Variable
	private static int maxProductII(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int min = A[0];
		int max = A[0];
		int result = A[0];

		for (int i = 1; i < A.length; i++) {
			int temp = min;
			min = Math.min(Math.min(min * A[i], A[i]), max * A[i]);
			max = Math.max(Math.max(max * A[i], A[i]), temp * A[i]);
			result = Math.max(result, max);
		}

		return result;
	}
}
