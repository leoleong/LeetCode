package search;

public class Searcha2DMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		boolean result = searchMatrix(matrix, 0);
		System.out.println(result);
	}

	// ----------------------------------------------------------------
	// once binary-search
	public static boolean searchMatrix(int[][] matrix, int target) {

		int row = matrix.length;
		int column = matrix[0].length;
		int start = 0;
		int end = row * column - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (matrix[mid / column][mid % column] > target) {
				end = mid - 1;
			} else if (matrix[mid / column][mid % column] < target) {
				start = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}

	// ----------------------------------------------------------------
	// twice binary-search
	public static boolean searchMatrix_1(int[][] matrix, int target) {

		int row = matrix.length - 1;
		int column = matrix[0].length - 1;

		if (matrix[row][column] < target) {
			return false;
		} else {
			int start = 0;
			int end = row;
			int mid;
			int index = -1;

			while (start <= end) {
				mid = (start + end) / 2;
				if (matrix[mid][column] < target) {
					start = mid + 1;
					index = start;
				} else if (matrix[mid][column] > target) {
					end = mid - 1;
					index = mid;
				} else {
					return true;
				}
			}

			start = 0;
			end = column;
			while (start <= end) {
				mid = (start + end) / 2;
				if (matrix[index][mid] > target) {
					end = mid - 1;
				} else if (matrix[index][mid] < target) {
					start = mid + 1;
				} else {
					return true;
				}
			}

			return false;
		}
	}
}
