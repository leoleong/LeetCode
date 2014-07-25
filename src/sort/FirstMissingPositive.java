package sort;

/**
 * author : leo
 * date : 2014-5-19
 * comment : 
 * 线性排序(非交换排序)
 * counting/radix/bucket
 */
public class FirstMissingPositive {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 1 };
		int result = firstMissingPositive(A);
		System.out.println(result);
	}

	public static int firstMissingPositive(int[] A) {

		int length = A.length;
		int i;

		for (i = 0; i < A.length; i++) {
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] > length || A[i] == A[A[i] - 1]) {
					break;
				}
				swap(A, i, A[i] - 1);
			}
		}
		for (i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				break;
			}
		}

		return i + 1;
	}

	private static void swap(int[] A, int m, int n) {

		int tmp = A[m];
		A[m] = A[n];
		A[n] = tmp;
	}
}
