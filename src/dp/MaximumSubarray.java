package dp;

/**
 * author : leo
 * date : 2014-5-22
 * comment : 
 * Typical DP(actually 2 dp(s):dp,max)
 */
public class MaximumSubarray {

	public static void main(String[] args) {

		int[] A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray(A);
		System.out.println(result);
	}

	public static int maxSubArray(int[] A) {

		// special test case
		if (A.length==0) {
			return 0;
		}

		// functional test case
		int dp = A[0];
		int max = dp;

		for (int i = 1; i < A.length; i++) {
			dp = Math.max(dp + A[i], A[i]);
			max = Math.max(max, dp);
		}

		return max;
	}
}
