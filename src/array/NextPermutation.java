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
 */
package array;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 3, 2 };

		nextPermutation(nums);

		System.out.println(Arrays.toString(nums));
	}

	public static void nextPermutation(int[] nums) {

		int length = nums.length;
		int pivot = length - 2;
		
		while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
			pivot--;
		}
		if (pivot >= 0) {
			int i = length - 1;
			while (nums[pivot] >= nums[i]) {
				i--;
			}
			swap(nums, pivot, i);
		}
		reverse(nums, pivot + 1, length - 1);
	}

	private static void swap(int[] nums, int src, int dst) {

		int tmp = nums[src];
		nums[src] = nums[dst];
		nums[dst] = tmp;
	}

	private static void reverse(int[] nums, int l, int r) {

		while (l < r) {
			swap(nums, l++, r--);
		}
	}
}
