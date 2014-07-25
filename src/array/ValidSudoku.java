package array;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {

		HashSet<Character> set = new HashSet<Character>(9);
		for (int i = 0; i < board.length; i++) {
			set.clear();
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					return false;
				}
				set.add(board[i][j]);
			}
		}

		for (int i = 0; i < board.length; i++) {
			set.clear();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != '.' && set.contains(board[j][i])) {
					return false;
				}
				set.add(board[j][i]);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set.clear();
				for (int m = 3 * i; m < 3 * i + 3; m++) {
					for (int n = 3 * j; n < 3 * j + 3; n++) {
						if (board[m][n] != '.' && set.contains(board[m][n])) {
							return false;
						}
						set.add(board[m][n]);
					}
				}
			}
		}
		return true;
	}
}
