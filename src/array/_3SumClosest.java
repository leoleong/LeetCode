/**
 * Problem:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package array;

import java.util.Arrays;

public class _3SumClosest {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 1, 1, 0 };
		System.out.println(threeSumClosest(num, -100));
	}

	public static int threeSumClosest(int[] num, int target) {

		if (num == null || num.length < 3) {
			return Integer.MIN_VALUE;
		}

		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		int sum = 0;

		for (int i = 0; i <= num.length - 3; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				sum = num[i] + num[j] + num[k];
				if (sum == target) {
					return target;
				} else if (sum < target) {
					j++;
				} else {
					k--;
				}
				result = Math.abs(sum - target) < Math.abs(result - target) ? sum
						: result;
			}
		}

		return result;
	}
}
