package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O' } };

		solve(board);

		int row = board.length;
		int column = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solve(char[][] board) {

		if (board.length <= 2) {
			return;
		} else {
			int row = board.length;
			int column = board[0].length;
			for (int i = 0; i <= row - 1; i++) {
				bfs(board, i, 0);
				bfs(board, i, column - 1);
			}
			for (int j = 0; j <= column - 1; j++) {
				bfs(board, 0, j);
				bfs(board, row - 1, j);
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					} else if (board[i][j] == '+') {
						board[i][j] = 'O';
					}
				}
			}
		}
	}

	private static void bfs(char[][] board, int row, int column) {

		if (board[row][column] != 'O') {
			return;
		}
		
		int rlength = board.length;
		int clength = board[0].length;
		Queue<Integer> queue = new ArrayDeque<Integer>();

		board[row][column] = '+';
		queue.offer(row * clength + column);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			int r = head / clength;
			int c = head % clength;
			if (r - 1 >= 0 && board[r - 1][c] == 'O') {
				board[r - 1][c] = '+';
				queue.offer((r - 1) * clength + c);
			}
			if (r + 1 < rlength && board[r + 1][c] == 'O') {
				board[r + 1][c] = '+';
				queue.offer((r + 1) * clength + c);
			}
			if (c - 1 >= 0 && board[r][c - 1] == 'O') {
				board[r][c - 1] = '+';
				queue.offer(r * clength + c - 1);
			}
			if (c + 1 < clength && board[r][c + 1] == 'O') {
				board[r][c + 1] = '+';
				queue.offer(r * clength + c + 1);
			}
		}
	}
}
