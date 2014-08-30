/**
 * Problem:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 	
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
package array;

public class SingleNumber {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 1, 2, 2, 3 };
		int result = singleNumber(A);
		System.out.println(result);
	}

	private static int singleNumber(int[] A) {

		int result = 0;

		for (int a : A) {
			result ^= a;
		}

		return result;
	}
}
