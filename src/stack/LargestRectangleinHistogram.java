/**
 * Problem:
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {

		int[] height = new int[] { 2, 1, 5, 6, 2, 3 };
		int result = largestRectangleArea(height);
		System.out.println(result);
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
