/**
 * Problem:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
package dp;

public class ClimbingStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(44));
	}

	// Method 1: Sequence DP
	public static int climbStairs(int n) {

		if (n < 2) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	// Method 2: Sequence DP + Single Variable
	public static int climbStairsWithSingleVar(int n) {

		int prev = 0;
		int cur = 1;
		int temp;

		for (int i = 1; i <= n; i++) {
			temp = prev + cur;
			prev = cur;
			cur = temp;
		}

		return cur;
	}

	// Method 3: recursion
	public static int climbStairsRecursively(int n) {

		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}
}
