/**
 * Problem:
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: 
 * You can only move either down or right at any point in time.
 */
package dp;

public class MinimumPathSum {

	public static void main(String[] args) {

	}

	public static int minPathSum(int[][] grid) {

		// special test case
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		// functional test case
		int row = grid.length;
		int column = grid[0].length;
		int[][] dp = new int[row][column];

		dp[0][0] = grid[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < column; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
			}
		}

		return dp[row - 1][column - 1];
	}
}
