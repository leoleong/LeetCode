package dp;

public class MinimumPathSum {

	public static void main(String[] args) {

	}

	public static int minPathSum(int[][] grid) {

		// special test case
		if (grid.length == 0) {
			return 0;
		}
		
		// functional test case
		int row = grid.length;
		int column = grid[0].length;
		int[][] f = new int[row][column];
		f[0][0] = grid[0][0];

		for (int i = 1; i < row; i++) {
			f[i][0] = f[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < column; j++) {
			f[0][j] = f[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
			}
		}

		return f[row - 1][column - 1];
	}
}
