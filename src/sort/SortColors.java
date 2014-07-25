package sort;

import java.util.Arrays;

/**
 * author : leo date : 2014-5-19 comment : swap函数在数组中交换特别注意，异或版本的swap可能不适合 循环不变式
 */
public class SortColors {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 0, 2, 0, 0, 1, 2, 1, 0 };
		sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
	// 2. counting sort (not stable tranformation) : O(2*n)
	public static void sortColors_1(int[] A){
		
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

	// 1. loop invariant : O(n)
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

	private static void swap(int[] A, int m, int n) {

		int tmp = A[m];
		A[m] = A[n];
		A[n] = tmp;
	}
}
