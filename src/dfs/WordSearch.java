/**
 * Problem:
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * [
 * 	["ABCE"],
 * 	["SFCS"],
 * 	["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
package dfs;

public class WordSearch {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		boolean result = exist(board, "ABCCEE");

		System.out.println(result);
	}

	public static boolean exist(char[][] board, String word) {

		int row = board.length;
		int column = board[0].length;
		boolean[][] used = new boolean[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (dfs(board, word, used, 0, i, j)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean dfs(char[][] board, String word, boolean[][] used, int index, int r, int c) {

		int row = board.length;
		int column = board[0].length;

		// convergence condition
		if (index == word.length()) {
			return true;
		}
		// pruning/terminal condition
		if (r < 0 || r >= row || c < 0 || c >= column) {
			return false;
		}
		// pruning condition
		if (used[r][c] == true || word.charAt(index) != board[r][c]) {
			return false;
		}

		used[r][c] = true;
		boolean ret = dfs(board, word, used, index + 1, r + 1, c) || dfs(board, word, used, index + 1, r - 1, c)
				|| dfs(board, word, used, index + 1, r, c + 1) || dfs(board, word, used, index + 1, r, c - 1);
		used[r][c] = false;

		return ret;
	}
}
