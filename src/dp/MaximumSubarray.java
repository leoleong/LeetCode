/**
 * Problem:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package dp;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray(A);
		System.out.println(result);
	}

	public static int maxSubArray(int[] A) {

		// corner condition test case
		if (A == null || A.length == 0) {
			return 0;
		}

		// normal test case
		int dp = A[0];
		int max = dp;

		for (int i = 1; i < A.length; i++) {
			dp = Math.max(dp + A[i], A[i]);
			max = Math.max(max, dp);
		}

		return max;
	}
}
