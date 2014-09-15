/**
 * Problem:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 	- Elements in a triplet (a,b,c) must be in non-descending order. (ie, a<=b<=c)
 * 	- The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _3Sum {

	public static void main(String[] args) {

		int[] num = new int[] { 0, 0, 0 };
		List<List<Integer>> result = threeSum(num);
		System.out.println(result);
	}

	// Method 1: 2 pointer
	public static List<List<Integer>> threeSum(int[] num) {

		if (num == null || num.length < 3) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i <= num.length - 3 && num[i] <= 0; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					result.add(list);
					j++;
					k--;
					while (j < k && num[j] == num[j - 1]) {
						j++;
					}
					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return result;
	}

	// Method 2: HashMap
	public static ArrayList<ArrayList<Integer>> hashThreeSum(int[] num) {

		if (num == null || num.length < 3) {
			return new ArrayList<ArrayList<Integer>>();
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : num) {
			if (map.containsKey(i)) {
				int value = map.get(i) + 1;
				map.put(i, value);
			} else {
				map.put(i, 1);
			}
		}

		Arrays.sort(num);
		boolean endFlag = false;
		boolean case1, case2, case3;
		ArrayList<Integer> list = new ArrayList<Integer>(3);
		for (int i = 0; i < num.length; i++) {
			if (endFlag) {
				break;
			}
			for (int j = i + 1; j < num.length; j++) {
				int addend1 = num[i];
				int addend2 = num[j];
				int target = 0 - (addend1 + addend2);
				if (target < 0) {
					endFlag = true;
					break;
				} else if (addend2 > -addend1 / 2) {
					break;
				}
				if (map.containsKey(target)) {
					case1 = (target == addend1 && target == addend2 && map
							.get(target) >= 3);
					case2 = (target == addend1 || target == addend2)
							&& map.get(target) >= 2;
					case3 = (target != addend1 && target != addend2);
					if (case1 || case2 || case3) {
						list.clear();
						list.add(addend1);
						list.add(addend2);
						list.add(target);
						if (!result.contains(list)) {
							result.add(list);
						}
					}
				}
			}
		}
		return result;
	}
}
