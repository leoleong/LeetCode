package greedy;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * ���"һ��ɨ����������ɨ������ͬʱɨ"
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public static int maxArea(int[] height) {

		int cur, max;
		cur = max = 0;
		int start = 0;
		int end = height.length - 1;

		while (start < end) {
			cur = Math.min(height[start], height[end]) * (end - start);
			max = Math.max(max, cur);
			if (height[start] < height[end]) {
				start++;
			} else {
				end--;
			}
		}

		return max;
	}
}
