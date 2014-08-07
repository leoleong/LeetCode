/**
 * Problem:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 	- Integers in each row are sorted from left to right.
 * 	- The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
package search;

public class Searcha2DMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		boolean result = searchMatrix(matrix, 0);
		System.out.println(result);
	}

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
}
