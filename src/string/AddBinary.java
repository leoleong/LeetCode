/**
 * Problem:
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * 	a = "11"
 * 	b = "1"
 * Return "100".
 */
package string;

public class AddBinary {

	public static void main(String[] args) {

		String a = "1";
		String b = "111";

		String s = addBinary(a, b);

		System.out.println(s);
	}

	public static String addBinary(String a, String b) {

		char[] array1 = a.toCharArray();
		char[] array2 = b.toCharArray();
		int idx1 = array1.length - 1;
		int idx2 = array2.length - 1;
		int op1, op2;
		int carry = 0;
		String s = "";

		while (idx1 >= 0 && idx2 >= 0) {
			op1 = array1[idx1] - '0';
			op2 = array2[idx2] - '0';
			s = (op1 + op2 + carry) % 2 + s;
			carry = (op1 + op2 + carry) / 2;
			idx1--;
			idx2--;
		}
		while (idx1 >= 0) {
			op1 = array1[idx1] - '0';
			s = (op1 + carry) % 2 + s;
			carry = (op1 + carry) / 2;
			idx1--;
		}
		while (idx2 >= 0) {
			op2 = array2[idx2] - '0';
			s = (op2 + carry) % 2 + s;
			carry = (op2 + carry) / 2;
			idx2--;
		}
		if (carry == 1) {
			s = 1 + s;
		}

		return s;
	}
}
