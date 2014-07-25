package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * author : leo
 * date : 2014-5-19
 * comment : 
 * stack维护非递减数列
 */
public class LargestRectangleinHistogram {

	public static void main(String[] args) {

		int[] height = new int[] { 1 };

		int result = largestRectangleArea(height);

		System.out.println(result);
	}

	public static int largestRectangleArea(int[] height) {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int[] h = Arrays.copyOf(height, height.length + 1);
		int max = 0;

		for (int i = 0; i < h.length;) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int index = stack.pop();
				int width = stack.isEmpty() ? i : i - 1 - stack.peek();
				max = Math.max(max, h[index] * width);
			}
		}

		return max;
	}
}
