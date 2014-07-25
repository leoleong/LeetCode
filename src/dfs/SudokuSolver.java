package dfs;

public class SudokuSolver {

	public static void main(String[] args) {

		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
							{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
							{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
							{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
							{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
							{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
							{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
							{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
							{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }, };

		solveSudoku(board);

		for (char[] cs : board) {
			System.out.println(cs);
		}
	}

	public static void solveSudoku(char[][] board) {

		dfs(board, 0, 0);
	}

	private static boolean dfs(char[][] board, int row, int column) {

		if (column > 8) {
			return dfs(board, row + 1, 0);
		}
		// convergence condition
		if (row > 8) {
			return true;
		}
		// normal condition
		if (board[row][column] == '.') {
			for (int k = 1; k <= 9; k++) {
				board[row][column] = (char) ('0' + k);
				if (isValid(board, row, column)) {
					if(dfs(board, row, column + 1)){
						return true;
					}
				}
				board[row][column] = '.';
			}
		} else {
			return dfs(board, row, column + 1);
		}
		return false;
	}

	private static boolean isValid(char[][] board, int row, int column) {

		for (int j = 0; j < 9; j++) {
			if (board[row][j] == board[row][column] && j != column) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][column] == board[row][column] && i != row) {
				return false;
			}
		}
		for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
			for (int j = column / 3 * 3; j < column / 3 * 3 + 3; j++) {
				if (board[i][j] == board[row][column] && i != row && j != column) {
					return false;
				}
			}
		}
		return true;
	}
}
