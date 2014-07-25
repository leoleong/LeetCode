package string;

public class ValidNumber {

	public static void main(String[] args) {
		String s = " 2 ";

		boolean result = isNumber(s);

		System.out.println(result);
	}

	public static boolean isNumber(String s) {

		final int START = 0;
		final int SPACE = 1;
		final int SIGN = 2;
		final int DIGIT = 3;
		final int EXPONENT = 4;
		final int DOT = 5;
		int[][] transition = new int[][] { { -1, -1, 2, 3, -1, -1 }, { 1, -1, -1, -1, -1 }, { 1, -1, 3, -1, -1 }, { 1, -1, 3, 4, 5 },
				{ -1, 2, 3, -1, -1 }, { -1, -1, 3, -1, -1 } };
		int state = 1;
		int cur;
		char ch;

		int start = 0;
		int end = s.length() - 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				start = i;
				break;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				end = i;
				break;
			}
		}

		for (int i = start; i < end; i++) {
			ch = s.charAt(i);
			cur = START;
			if (Character.isSpaceChar(ch)) {
				cur = SPACE;
			} else if (ch == '+' || ch == '-') {
				cur = SIGN;
			} else if (Character.isDigit(ch)) {
				cur = DIGIT;
			} else if (ch == 'e' || ch == 'E') {
				cur = EXPONENT;
			} else if (ch == '.') {
				cur = DOT;
			}
			state = transition[state][cur];
			if (state == -1) {
				return false;
			}
		}

		return state == 1 || state == 3;
	}
}
