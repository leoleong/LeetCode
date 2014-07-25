package array;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 1, 2 };
		int result = removeDuplicates(A);
		System.out.println(result);
	}

	public static int removeDuplicates(int[] A) {

		if (A.length <= 1)
			return A.length;

		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1])
				A[++index] = A[i];

		}

		return index + 1;
	}
}
