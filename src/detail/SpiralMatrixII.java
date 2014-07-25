package detail;

public class SpiralMatrixII {

	public static void main(String[] args) {

		int[][] result = generateMatrix(4);

		for (int[] rows : result) {
			for (int element : rows) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {

		int value = 1;
		int[][] result = new int[n][n];
		int startX, endX, startY, endY;
		startX = startY = 0;
		endX = endY = n - 1;

		while (true) {
			// left--right
			for (int j = startY; j <= endY; j++)
				result[startX][j] = value++;
			if (startX++ > endX)
				break;
			// top--down
			for (int i = startX; i <= endX; i++)
				result[i][endY] = value++;
			if (startY > --endY)
				break;
			// right--left
			for (int j = endY; j >= startY; j--)
				result[endX][j] = value++;
			if (startX > --endX)
				break;
			// down--top
			for (int i = endX; i >= startX; i--)
				result[i][startY] = value++;
			if (++startY > endY)
				break;
		}

		return result;
	}
}
