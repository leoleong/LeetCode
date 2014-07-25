package string;

public class AddBinary {

	public static void main(String[] args) {

		String a = "1";
		String b = "111";

		String s = addBinary(a, b);

		System.out.println(s);
	}

	public static String addBinary(String a, String b) {

		int aindex = a.length() - 1;
		int bindex = b.length() - 1;
		int ach, bch;
		int carry = 0;
		String s = "";

		while (aindex >= 0 && bindex >= 0) {
			ach = a.charAt(aindex) - '0';
			bch = b.charAt(bindex) - '0';
			s = (ach + bch + carry) % 2 + s;
			carry = (ach + bch + carry) / 2;
			aindex--;
			bindex--;
		}
		while (aindex >= 0) {
			ach = a.charAt(aindex) - '0';
			s = (ach + carry) % 2 + s;
			carry = (ach + carry) / 2;
			aindex--;
		}
		while (bindex >= 0) {
			bch = b.charAt(bindex) - '0';
			s = (bch + carry) % 2 + s;
			carry = (bch + carry) / 2;
			bindex--;
		}
		if (carry == 1) {
			s = '1' + s;
		}

		return s;
	}
}
