package dfs;

public class UniquePaths {

	public static void main(String[] args) {

		int result = uniquePaths_2(23, 12);

		System.out.println(result);
	}

	// 2-D DP : PASS
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

	// 1-D DP : PASS
	public static int uniquePaths_1(int m, int n) {

		int[] dp = new int[n];

		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}

		return dp[n - 1];
	}

	// DFS : TLE
	public static int uniquePaths_2(int m, int n) {

		if (m == 1 || n == 1)
			return 1;

		return uniquePaths_2(m - 1, n) + uniquePaths_2(m, n - 1);
	}
}
