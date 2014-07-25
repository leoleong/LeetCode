package array;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 3, 4 };
		int[] B = new int[] { 5, 6, 7, 8 };
		double result = findMedianSortedArrays(A, B);
		System.out.println(result);
	}

	public static double findMedianSortedArrays(int A[], int B[]) {

		int[] C = new int[A.length + B.length];
		int i = 0, j = 0, k = 0;
		
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}
		}
		while (i < A.length) {
			C[k++] = A[i++];
		}
		while (j < B.length) {
			C[k++] = B[j++];
		}
		
		double median;
		if (C.length % 2 == 1) {
			median = C[C.length / 2];
		} else {
			median = (double) (C[C.length / 2] + C[C.length / 2 - 1]) / 2;
		}
		
		return median;
	}
}
