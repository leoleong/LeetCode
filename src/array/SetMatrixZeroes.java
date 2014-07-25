package array;

public class SetMatrixZeroes {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 0, 6 } };

		setZeroes(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// time:O(m*n), space:O(1)
	public static void setZeroes(int[][] matrix) {

		int row = matrix.length;
		int column = matrix[0].length;
		boolean isRowZero = false;
		boolean isColumnZero = false;

		for (int i = 0; i < row && !isColumnZero; i++) {
			if (matrix[i][0] == 0) {
				isColumnZero = true;
			}
		}
		for (int j = 0; j < column && !isRowZero; j++) {
			if (matrix[0][j] == 0) {
				isRowZero = true;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if (isColumnZero) {
			for (int i = 0; i < row; i++) {
				matrix[i][0]=0;
			}
		}
		if (isRowZero) {
			for (int j = 0; j < column; j++) {
				matrix[0][j]=0;
			}
		}
	}

	// time:O(m*n), space:O(m+n)
	public static void setZeroes1(int[][] matrix) {

		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];

		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = columns[j] = true;
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				for (int j = 0; j < columns.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < columns.length; j++) {
			if (columns[j]) {
				for (int i = 0; i < rows.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
