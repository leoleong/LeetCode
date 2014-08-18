/**
 * Problem:
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
 * of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
package dp;

public class DistinctSubsequences {

	public static void main(String[] args) {

		String S = "rabbbit";
		String T = "rabbit";

		int result = numDistinct(S, T);

		System.out.println(result);
	}

	public static int numDistinct(String S, String T) {

		int[][] dp = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j < dp[0].length; j++) {
			for (int i = 1; i < dp.length; i++) {
				if (T.charAt(j - 1) == S.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[S.length()][T.length()];
	}
}
