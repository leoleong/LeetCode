/**
 * Problem:
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
package dfs;

public class NQueensII {

	private static int result;

	public static void main(String[] args) {

		int count = totalNQueens(8);

		System.out.println(count);
	}

	public static int totalNQueens(int n) {

		result = 0;
		int[] path = new int[n];

		dfs(path, 0);

		return result;
	}

	private static void dfs(int[] path, int row) {

		int N = path.length;

		if (row == N) {
			result++;
			return;
		}

		for (int j = 0; j < N; j++) {
			if (isValid(path, row, j)) {
				path[row] = j;
				dfs(path, row + 1);
			}
		}
	}

	private static boolean isValid(int[] path, int row, int column) {

		for (int i = 0; i < row; i++) {
			if (path[i] == column
					|| Math.abs(row - i) == Math.abs(column - path[i])) {
				return false;
			}
		}

		return true;
	}
}
