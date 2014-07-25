package dfs;

public class UniquePathsII {

	public static void main(String[] args) {

		int[][] obstacleGrid = new int[][] { { 0, 0 }, { 1, 0 } };

		int result = uniquePathsWithObstacles_1(obstacleGrid);

		System.out.println(result);
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		int[][] dp = new int[row][column];

		for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < column && obstacleGrid[0][j] == 0; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[row - 1][column - 1];
	}

	public static int uniquePathsWithObstacles_1(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		int[] dp = new int[column];

		// terminal condition
		if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][column - 1] == 1) {
			return 0;
		}

		// normal condition
		dp[0] = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				dp[j] = obstacleGrid[i][j] == 1 ? 0 : (j > 0 ? dp[j] + dp[j - 1] : dp[j]);
			}
		}

		return dp[column - 1];
	}
}
