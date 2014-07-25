package array;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 3, 2 };
		
		nextPermutation(num);
		
		for (int i : num) {
			System.out.print(i + " ");
		}
	}

	public static void nextPermutation(int[] num) {
		
		int length = num.length;
		for (int i = length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				int j = length - 1;
				while (num[i] >= num[j]) {
					j--;
				}
				num[i] = num[i] ^ num[j];
				num[j] = num[i] ^ num[j];
				num[i] = num[i] ^ num[j];
				Arrays.sort(num, i + 1, length);
				break;
			} else if (i == 0 && num[i] >= num[i + 1]) {
				num[i] = num[i] ^ num[length - 1];
				num[length - 1] = num[i] ^ num[length - 1];
				num[i] = num[i] ^ num[length - 1];
				Arrays.sort(num, i + 1, length);
			}
		}
	}
}
