/**
 * Problem:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 	- Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * 	- The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

	public static void main(String[] args) {

		int[] num = new int[] { 0, 0, 0, 0 };
		List<List<Integer>> result = fourSum(num, 0);
		System.out.println(result);
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (num == null || num.length < 4) {
			return result;
		}

		Arrays.sort(num);
		for (int i = 0; i <= num.length - 4 && num[i] <= target / 4; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int k = j + 1;
				int l = num.length - 1;
				while (k < l) {
					if (num[i] + num[j] + num[k] + num[l] == target) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[k]);
						list.add(num[l]);
						result.add(list);
						k++;
						l--;
						while (k < l && num[k] == num[k - 1]) {
							k++;
						}
						while (k < l && num[l] == num[l + 1]) {
							l--;
						}
					} else if (num[i] + num[j] + num[k] + num[l] < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}

		return result;
	}
}
