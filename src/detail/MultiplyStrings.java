/**
 * Problem:
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: 
 * The numbers can be arbitrarily large and are non-negative.
 */
package detail;

public class MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "9311";
		String num2 = "0";

		String result = multiply(num1, num2);

		System.out.println(result);
	}

	public static String multiply(String num1, String num2) {

		int[] n1 = transform(num1);
		int[] n2 = transform(num2);
		int[] n = new int[n1.length + n2.length];

		for (int i = 0; i < n1.length; i++) {
			for (int j = 0; j < n2.length; j++) {
				n[i + j] += n1[i] * n2[j];
				n[i + j + 1] += n[i + j] / 10;
				n[i + j] %= 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		int index = n.length - 1;
		while (index >= 0 && n[index] == 0) {
			index--;
		}
		while (index >= 0) {
			sb.append(n[index]);
			index--;
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

	private static int[] transform(String str) {

		int[] array = new int[str.length()];

		for (int i = 0; i < array.length; i++) {
			array[i] = str.charAt(str.length() - 1 - i) - '0';
		}

		return array;
	}
}
