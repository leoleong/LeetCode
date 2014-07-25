package array;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {

		int[] digits = new int[] { 9, 9, 9, 9 };
		int[] nDigits = plusOne(digits);
		System.out.println(Arrays.toString(nDigits));
	}

	public static int[] plusOne(int[] digits) {

		boolean flag = true;
		for (int i = digits.length - 1; i >= 0 && flag; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				flag = false;
			}
		}

		if (flag) {
			int[] nDigits = new int[digits.length + 1];
			nDigits[0] = 1;
			System.arraycopy(digits, 0, nDigits, 1, digits.length);
			return nDigits;
		} else {
			return digits;
		}
	}
}
