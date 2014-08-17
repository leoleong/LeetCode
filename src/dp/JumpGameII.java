/**
 * Problem:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
package dp;

public class JumpGameII {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 3, 1, 1, 4 };
		int result = jump(A);
		System.out.println(result);
	}

	// Method 1: Sequence DP(LTE)
	public static int jump(int[] A) {

		if (A.length <= 1) {
			return 0;
		}

		int[] dp = new int[A.length];
		dp[0] = 0;

		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (A[j] + j >= i && dp[j] + 1 < dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		return dp[A.length - 1];
	}

	// Method 2: Mixed
	public static int jumpMixed(int[] A) {

		int end = A.length - 1;
		int reach, lreach, step;
		reach = lreach = step = 0;

		for (int i = 0; i < end; i++) {
			reach = Math.max(reach, A[i] + i);
			if (i == lreach) {
				lreach = reach;
				step++;
			}
		}

		return step;
	}
}
