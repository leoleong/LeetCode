/**
 * Problem:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */
package sort;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 0, 2, 0, 0, 1, 2, 1, 0 };
		sortColors(A);
		System.out.println(Arrays.toString(A));
	}

	// Method 1: loop invariant : O(n)
	public static void sortColors(int A[]) {

		int i, j, k;
		i = j = 0;
		k = A.length - 1;

		while (j <= k) {
			if (A[j] == 0) {
				swap(A, i++, j++);
			} else if (A[j] == 1) {
				j++;
			} else if (A[j] == 2) {
				swap(A, j, k--);
			}
		}
	}

	// Method 2: counting sort (not stable tranformation) : O(2*n)
	public static void sortColors_1(int[] A) {

		int[] count = new int[3];
		for (int a : A) {
			count[a] += 1;
		}

		int index = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				A[index++] = i;
			}
		}
	}

	private static void swap(int[] A, int src, int dst) {

		int temp = A[src];
		A[src] = A[dst];
		A[dst] = temp;
	}
}
