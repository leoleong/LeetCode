/**
 * Problem:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: 
 * You may not slant the container.
 */
package greedy;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	// greedy could reach global optimum
	public static int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int max = 0;

		while (left < right) {
			int cur = Math.min(height[left], height[right]) * (right - left);
			max = Math.max(max, cur);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return max;
	}
}
