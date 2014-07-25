package dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {

		List<String[]> result = solveNQueens(4);

		for (String[] strs : result) {
			for (String str : strs) {
				System.out.println(str);
			}
			System.out.println();
		}
	}

	public static List<String[]> solveNQueens(int n) {

		List<String[]> result = new ArrayList<String[]>();
		int[] path = new int[n];

		dfs(result, path, 0);

		return result;
	}

	private static void dfs(List<String[]> result, int[] path, int row) {

		int N = path.length;
		// convergence condition
		if (row == N) {
			String[] strs = new String[N];
			for (int i = 0; i < N; i++) {
				StringBuilder str = new StringBuilder(N);
				for (int j = 0; j < N; j++) {
					if (j != path[i]) {
						str.insert(j, '.');
					} else {
						str.insert(j, 'Q');
					}
				}
				strs[i] = str.toString();
			}
			result.add(strs);
			return;
		}
		// normal condition
		for (int j = 0; j < N; j++) {
			if (isValid(path, row, j)) {
				path[row] = j;
				dfs(result, path, row + 1);
			}
		}
	}

	private static boolean isValid(int[] path, int row, int column) {

		for (int i = 0; i < row; i++) {
			if (column == path[i] || Math.abs(column - path[i]) == Math.abs(row - i)) {
				return false;
			}
		}

		return true;
	}
}
