/**
 * Problem:
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: 
 * Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: 
 * It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 * and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
package string;

public class StringtoInteger {

	public static void main(String[] args) {

		String str = "  -2147483648";

		int result = atoi(str);

		System.out.println(result);
	}

	public static int atoi(String str) {

		int length = str.length();
		int i = 0;
		char ch = '+';
		boolean negative = false;
		int sum = 0;

		// detele front space
		for (; i < length; i++) {
			ch = str.charAt(i);
			if (!Character.isWhitespace(ch)) {
				break;
			}
		}

		// get sign
		if (ch == '-') {
			negative = true;
			i++;
		} else if (ch == '+') {
			i++;
		}

		// transform
		for (; i < length; i++) {
			ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				if (sum > Integer.MAX_VALUE / 10
						|| (sum == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10)) {
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				sum = sum * 10 + ch - '0';
			} else {
				// incomplete Test Case, it may have space in middle
				break;
			}
		}

		return negative ? -sum : sum;
	}
}
