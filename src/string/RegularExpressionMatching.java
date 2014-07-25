package string;

public class RegularExpressionMatching {

	public static void main(String[] args) {

		String s = "ab";
		String p = ".*c";

		boolean result = isMatch(s, p);

		System.out.println(result);
	}

	public static boolean isMatch(String s, String p) {

		return isMatch(s, p, 0, 0);
	}

	private static boolean isMatch(String s, String p, int i, int j) {

		if (j == p.length()) {
			return i == s.length();
		}

		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
				return isMatch(s, p, i + 1, j + 1);
			} else {
				return false;
			}
		} else {
			while (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
				if (isMatch(s, p, i, j + 2)) {
					return true;
				}
				i++;
			}
			return isMatch(s, p, i, j + 2);
		}
	}
}
