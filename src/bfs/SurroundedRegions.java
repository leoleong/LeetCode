/**
 * Problem:
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * 	X X X X
 * 	X O O X
 * 	X X O X
 * 	X O X X
 * After running your function, the board should be:
 * 	X X X X
 * 	X X X X
 * 	X X X X
 * 	X O X X
 * 
 * Note:
 * 1. DFS method might cause 'StackOverflowError' when using a large testcase.
 */
package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'O', 'O', 'O', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' },
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

		if (board == null || board.length <= 2 || board[0].length <= 2) {
			return;
		}

		int row = board.length;
		int column = board[0].length;
		for (int i = 0; i < row; i++) {
			bfs(board, i, 0);
			bfs(board, i, column - 1);
		}
		for (int j = 0; j < column; j++) {
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

	private static void bfs(char[][] board, int r, int c) {

		if (board[r][c] != 'O') {
			return;
		}

		int row = board.length;
		int column = board[0].length;
		Queue<Integer> queue = new ArrayDeque<Integer>();

		board[r][c] = '+';
		queue.offer(r * column + c);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			r = head / column;
			c = head % column;
			if (r - 1 >= 0 && board[r - 1][c] == 'O') {
				board[r - 1][c] = '+';
				queue.offer((r - 1) * column + c);
			}
			if (r + 1 < row && board[r + 1][c] == 'O') {
				board[r + 1][c] = '+';
				queue.offer((r + 1) * column + c);
			}
			if (c - 1 >= 0 && board[r][c - 1] == 'O') {
				board[r][c - 1] = '+';
				queue.offer(r * column + c - 1);
			}
			if (c + 1 < column && board[r][c + 1] == 'O') {
				board[r][c + 1] = '+';
				queue.offer(r * column + c + 1);
			}
		}
	}

	private static void dfs(char[][] board, int r, int c) {

		int row = board.length;
		int column = board[0].length;

		if (r < 0 || r >= row || c < 0 || c >= column || board[r][c] != 'O') {
			return;
		}

		board[r][c] = '+';
		dfs(board, r - 1, c);
		dfs(board, r + 1, c);
		dfs(board, r, c - 1);
		dfs(board, r, c + 1);
	}
}
