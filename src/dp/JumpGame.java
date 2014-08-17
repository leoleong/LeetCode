/**
 * Problem:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
package dp;

public class JumpGame {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 3, 0, 2, 0, 2 };
		boolean result = canJump(A);
		System.out.println(result);
	}

	// Method 1: Sequence DP
	public static boolean canJump(int[] A) {

		if (A.length <= 1) {
			return true;
		}

		boolean[] dp = new boolean[A.length];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && A[j] + j >= i) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[A.length - 1];
	}

	// Method 2: Mixed
	public static boolean canJumpMixed(int[] A) {

		int end = A.length - 1;
		int reach = 0;

		for (int i = 0; i <= reach && reach < end; i++) {
			reach = Math.max(reach, i + A[i]);
		}

		return reach >= end;
	}
}
