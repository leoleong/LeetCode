package dp;

public class MaximalRectangle {

	public static void main(String[] args) {

		char[][] matrix = new char[][] { { '0', '0', '0' }, { '0', '0', '0' }, { '1', '1', '1' } };
		int result = maximalRectangle(matrix);
		System.out.println(result);
	}

	public static int maximalRectangle(char[][] matrix) {

		// special test case
		if (matrix.length == 0) {
			return 0;
		}
		
		// functional test case
		int max = 0;
		int left, right;
		int row = matrix.length;
		int column = matrix[0].length;
		int[] L = new int[column];
		int[] R = new int[column];
		int[] H = new int[column];
		for (int i = 0; i < column; i++) {
			R[i] = column;
		}

		for (int i = 0; i < row; i++) {
			left = 0;
			right = column;
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == '1') {
					H[j]++;
					L[j] = Math.max(L[j], left);
				} else {
					H[j] = L[j] = 0;
					R[j] = column;
					left = j + 1;
				}
			}
			for (int j = column - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					R[j] = Math.min(R[j], right);
					max = Math.max(max, H[j] * (R[j] - L[j]));
				} else {
					right = j;
				}
			}
		}

		return max;
	}
}
