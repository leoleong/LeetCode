/**
 * Problem:
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
package array;

public class PermutationSequence {

	public static void main(String[] args) {

		String s = getPermutation(9, 6);

		System.out.println(s);
	}

	public static String getPermutation(int n, int k) {

		StringBuilder sb = new StringBuilder(n);
		int[] nums = new int[n];
		int factorial = 1;
		for (int i = 0; i < n; i++) {
			factorial *= i + 1;
			nums[i] = i + 1;
		}

		k--;
		for (int i = 0; i < n; i++) {
			factorial /= n - i;
			int index = k / factorial;
			sb.append(nums[index]);
			while (index < n - 1 - i) {
				nums[index] = nums[index + 1];
				index++;
			}
			k %= factorial;
		}

		return sb.toString();
	}
}
