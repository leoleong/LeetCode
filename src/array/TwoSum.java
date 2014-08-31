/**
 * Problem:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] numbers = new int[] { 3, 2, 4 };
		int[] pair = twoSumWithHash(numbers, 6);
		System.out.println(Arrays.toString(pair));
	}

	// Method 1: trival problem, pass
	public static int[] twoSumWithHash(int[] numbers, int target) {

		if (numbers == null || numbers.length < 2) {
			return null;
		}

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(numbers[i]) < map.get(target - numbers[i]) ? map
						.get(numbers[i]) : map.get(target - numbers[i]);
				result[1] = map.get(numbers[i]) > map.get(target - numbers[i]) ? map
						.get(numbers[i]) : map.get(target - numbers[i]);
				return result;
			}
		}

		return null;
	}

	// Mehtod 2: error because of reorder
	public static int[] twoSum(int[] numbers, int target) {

		if (numbers == null || numbers.length < 2) {
			return null;
		}

		Arrays.sort(numbers);
		int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return null;
	}
}
