/**
 * Problem:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [鈭�,1,鈭�,4,鈭�,2,1,鈭�,4],
 * the contiguous subarray [4,鈭�,2,1] has the largest sum = 6.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package dp;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArrayI(A);
		System.out.println(result);
	}

	// Method 1: Single Variable
	private static int maxSubArray(int[] A) {

		// corner condition test case
		if (A == null || A.length == 0) {
			return 0;
		}

		// normal test case
		int dp = A[0];
		int max = A[0];

		for (int i = 1; i < A.length; i++) {
			dp = Math.max(dp + A[i], A[i]);
			max = Math.max(max, dp);
		}

		return max;
	}

	// Method 2: Sequence DP
	private static int maxSubArrayI(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int[] dp = new int[A.length];
		dp[0] = A[0];
		int max = A[0];

		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
