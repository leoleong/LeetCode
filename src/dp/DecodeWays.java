/**
 * Problem:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 	'A' -> 1
 * 	'B' -> 2
 * 	...
 * 	'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
package dp;

public class DecodeWays {

	public static void main(String[] args) {

		String s = "101";
		int result = numDecodings(s);
		System.out.println(result);
	}

	// Method 1: Sequence DP
	public static int numDecodings(String s) {

		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			// '0' is the first criteria
			if (s.charAt(i - 1) != '0') {
				dp[i] = dp[i - 1];
			}
			if (s.charAt(i - 2) == '1'
					|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];
	}

	// Method 2: Sequence DP + Single Variable
	public static int numDecodingsWithSingleVar(String s) {

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
			if ((s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') || i < 2
					|| !(s.charAt(i - 2) == '1')) {
				prev = 0;
			}
			tmp = prev + cur;
			prev = cur;
			cur = tmp;
		}

		return cur;
	}
}
