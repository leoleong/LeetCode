/**
 * Problem:
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
package array;

public class SingleNumberII {

	public static void main(String[] args) {

	}

	public static int singleNumber(int[] A) {
		
		int result = 0;
		
		for (int i = 0; i < 32; i++) {
			int val = 0;
			for (int a : A) {
				val += (a >> i) & 1;
			}
			result += (val % 3) << i;
		}
		
		return result;
	}
}
