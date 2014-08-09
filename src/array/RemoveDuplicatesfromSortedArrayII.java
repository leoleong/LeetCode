/**
 * Problem:
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
package array;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 1, 1, 2, 2, 3 };
		int result = removeDuplicates(A);
		System.out.println(result);
	}

	public static int removeDuplicates(int[] A) {

		if (A == null || A.length == 0) {
			return A.length;
		}

		int index = 0;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[index] != A[i]) {
				A[++index] = A[i];
				count = 1;
			} else if (A[index] == A[i] && count < 2) {
				A[++index] = A[i];
				count++;
			} else {
				count++;
			}
		}

		return index + 1;
	}
}
