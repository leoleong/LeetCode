package string;

public class IntegertoRoman {

	public static void main(String[] args) {

		String result = intToRoman(2949);

		System.out.println(result);
	}

	public static String intToRoman(int num) {

		int[] radix = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbol = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String roman = "";

		for (int i = 0; num > 0; i++) {
			int count = num / radix[i];
			for (; count > 0; count--) {
				roman += symbol[i];
			}
			num %= radix[i];
		}

		return roman;
	}
}
