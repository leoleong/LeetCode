package sort;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 3, 5, 0, 0, 0 };
		int[] B = new int[] { 2, 4, 6 };
		merge(A, 3, B, 3);
		System.out.println(Arrays.toString(A));
	}

	public static void merge(int A[], int m, int B[], int n) {

		int index = m + n - 1;
		m--;
		n--;

		while (m >= 0 && n >= 0) {
			A[index--] = A[m] > B[n] ? A[m--] : B[n--];
		}
		while (n >= 0) {
			A[index--] = B[n--];
		}
	}
}
