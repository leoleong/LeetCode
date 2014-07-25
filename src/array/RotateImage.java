package array;

public class RotateImage {

	public static void main(String[] args) {

		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {

		int length = matrix.length;
		for (int i = 0; i < length-1; i++) {
			for (int j = 0; j < length-1-i; j++) {
				matrix[i][j] = matrix[i][j]^matrix[length-1-j][length-1-i];
				matrix[length-1-j][length-1-i] = matrix[i][j]^matrix[length-1-j][length-1-i];
				matrix[i][j] = matrix[i][j]^matrix[length-1-j][length-1-i];
			}
		}
		for (int i = 0; i <= length/2-1 ; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = matrix[i][j]^matrix[length-1-i][j];
				matrix[length-1-i][j] = matrix[i][j]^matrix[length-1-i][j];
				matrix[i][j] = matrix[i][j]^matrix[length-1-i][j];
			}
		}
	}
}
