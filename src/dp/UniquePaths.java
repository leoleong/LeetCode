/**
 * Problem:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * Note: 
 * m and n will be at most 100.
 */
package dp;

public class UniquePaths {

	public static void main(String[] args) {

		int result = uniquePaths(23, 12);

		System.out.println(result);
	}

	// Method 1: Matrix DP
	public static int uniquePaths(int m, int n) {

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	// Method 2: Matrix DP + Rolling Array
	public static int uniquePathsWith1D(int m, int n) {

		int[] dp = new int[n];

		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}

		return dp[n - 1];
	}

	// Method 3: DFS
	public static int uniquePathsWithDFS(int m, int n) {

		if (m == 1 || n == 1)
			return 1;

		return uniquePathsWithDFS(m - 1, n) + uniquePathsWithDFS(m, n - 1);
	}
}
