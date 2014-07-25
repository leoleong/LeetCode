package string;

/**
 * author : leo
 * date : 2014-5-20
 * comment : 
 * 注意越界的处理
 */
public class StringtoInteger {

	public static void main(String[] args) {

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		String str = "  -2147483647";

		int result = atoi(str);

		System.out.println(result);
	}

	public static int atoi(String str) {

		int length = str.length();
		int i = 0;
		char ch = '+';
		int sign = 1;
		int sum = 0;

		// detele blank
		for (; i < length; i++) {
			ch = str.charAt(i);
			if (!Character.isWhitespace(ch)) {
				break;
			}
		}
		// get sign
		if (ch == '-') {
			sign = -1;
			i++;
		} else if (ch == '+') {
			i++;
		}
		// return integer
		for (; i < length; i++) {
			ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				if (sum > Integer.MAX_VALUE / 10) {
					return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				} else if (sum == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) {
					return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				sum = sum * 10 + ch - '0';
			} else {
				break;
			}
		}

		return sign * sum;
	}
}
