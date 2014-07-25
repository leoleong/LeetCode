package detail;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		List<Integer> result = spiralOrder(matrix);

		System.out.println(result);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0)
			return result;

		int startX, startY, endX, endY;
		startX = startY = 0;
		endX = matrix.length - 1;
		endY = matrix[0].length - 1;

		while (true) {
			// left--right
			for (int j = startY; j <= endY; j++)
				result.add(matrix[startX][j]);
			if (++startX > endX)
				break;
			// top--down
			for (int i = startX; i <= endX; i++)
				result.add(matrix[i][endY]);
			if (startY > --endY)
				break;
			// right--left
			for (int j = endY; j >= startY; j--)
				result.add(matrix[endX][j]);
			if (startX > --endX)
				break;
			// down--top
			for (int i = endX; i >= startX; i--)
				result.add(matrix[i][startY]);
			if (++startY > endY)
				break;
		}

		return result;
	}
}
