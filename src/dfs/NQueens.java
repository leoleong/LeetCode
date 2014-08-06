/**
 * Problem:
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * 	[".Q..",  // Solution 1
 * 	 "...Q",
 * 	 "Q...",
 * 	  "..Q."],
 * 
 * 	["..Q.",  // Solution 2
 * 	 "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
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
		
		for (int j = 0; j < N; j++) {
			if (isValid(path, row, j)) {
				path[row] = j;
				dfs(result, path, row + 1);
			}
		}
	}

	private static boolean isValid(int[] path, int row, int column) {

		for (int i = 0; i < row; i++) {
			if (column == path[i]
					|| Math.abs(column - path[i]) == Math.abs(row - i)) {
				return false;
			}
		}

		return true;
	}
}
