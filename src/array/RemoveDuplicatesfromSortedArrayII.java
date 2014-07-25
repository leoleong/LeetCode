package array;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 1, 1, 2, 2, 3 };
		int result = removeDuplicates(A);
		System.out.println(result);
	}

	public static int removeDuplicates(int[] A) {

		if (A.length <= 2)
			return A.length;

		int index = 0;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[++index] = A[i];
				count = 1;
			} else if (A[i] == A[i - 1] && count < 2) {
				A[++index] = A[i];
				count++;
			} else {
				count++;
			}
		}

		return index + 1;
	}
}
