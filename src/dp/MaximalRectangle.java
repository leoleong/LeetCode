/**
 * Problem:
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 */
package dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximalRectangle {

	public static void main(String[] args) {

		char[][] matrix = new char[][] { { '0', '0', '0' }, { '0', '0', '0' },
				{ '1', '1', '1' } };
		int result = maximalRectangle(matrix);
		System.out.println(result);
	}

	private static int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int[] height = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
			}
			max = Math.max(max, largestRectangleArea(height));
		}

		return max;
	}

	private static int largestRectangleArea(int[] height) {

		if (height == null || height.length == 0) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int[] h = Arrays.copyOf(height, height.length + 1);
		int max = 0;

		for (int i = 0; i < h.length;) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int index = stack.pop();
				int width = stack.isEmpty() ? i : (i - 1) - stack.peek();
				max = Math.max(max, h[index] * width);
			}
		}

		return max;
	}
}
