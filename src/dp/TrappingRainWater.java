/**
 * Problem:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
package dp;

public class TrappingRainWater {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 0, 2 };
		int result = trap(A);
		System.out.println(result);
	}

	public static int trap(int[] A) {

		if (A == null || A.length <= 2) {
			return 0;
		}

		int[] left = new int[A.length];
		left[0] = A[0];
		int[] right = new int[A.length];
		right[A.length - 1] = A[A.length - 1];
		int result = 0;

		for (int i = 1; i < A.length; i++) {
			left[i] = Math.max(left[i - 1], A[i]);
		}
		for (int i = A.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], A[i]);
		}
		for (int i = 1; i < A.length - 1; i++) {
			int min = Math.min(left[i], right[i]);
			if (A[i] < min) {
				result += min - A[i];
			}
		}
		
		return result;
	}
}
