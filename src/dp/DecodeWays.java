package dp;

public class DecodeWays {

	public static void main(String[] args) {

		String s = "1212";
		int result = numDecodings(s);
		System.out.println(result);
	}

	public static int numDecodings(String s) {

		int length = s.length();

		// special test case
		if (length == 0) {
			return 0;
		}

		// functional test case
		int prev = 0;
		int cur = 1;
		int tmp;

		for (int i = 1; i <= length; i++) {
			if (s.charAt(i - 1) == '0') {
				cur = 0;
			}
			if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
				prev = 0;
			}
			tmp = prev + cur;
			prev = cur;
			cur = tmp;
		}

		return cur;
	}
}
