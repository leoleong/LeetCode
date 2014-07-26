/**
 * Problem:
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * Follow-up question: 
 * could you implement previous permutation?
 * 
 * Notes: once LeetCode accepts your next() implementation, you can use the following code to verify your previous() on LeetCode:
 * 	public void nextPermutation(int[] num) {
 *     	next(num);
 *     	previous(num);
 *     	next(num);
 * 	}
 * same as nextPermutation
 */
package array;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 3, 2 };

//		nextPermutation(nums);
		previousPermutation(nums);

		System.out.println(Arrays.toString(nums));
		
	}

	public static void nextPermutation(int[] nums) {

		int length = nums.length;
		int index = length - 2;

		for (; index >= 0; index--) {
			if (nums[index] < nums[index + 1]) {
				break;
			}
		}

		if (index >= 0) {
			int pivot = length - 1;
			while (nums[index] >= nums[pivot]) {
				pivot--;
			}
			swap(nums, index, pivot);
		}

		reverse(nums, index + 1, length - 1);
	}

	public static void previousPermutation(int[] nums) {

		int length = nums.length;
		int index = length - 2;

		for (; index >= 0; index--) {
			if (nums[index] > nums[index + 1]) {
				break;
			}
		}

		if (index >= 0) {
			int pivot = length - 1;
			while (nums[index] <= nums[pivot]) {
				pivot--;
			}
			swap(nums, index, pivot);
		}

		reverse(nums, index + 1, length - 1);
	}

	private static void swap(int[] nums, int i, int j) {

		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void reverse(int[] nums, int l, int r) {

		while (l < r) {
			swap(nums, l++, r--);
		}
	}
}
