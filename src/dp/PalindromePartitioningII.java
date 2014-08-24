/**
 * Problem:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
package dp;

public class PalindromePartitioningII {

	public static void main(String[] args) {

		String s = "abb";

		int result = minCut(s);

		System.out.println(result);
	}

	// Method 1: Sequence DP(from start)
	public static int minCut(String s) {

		if (s.length() <= 1) {
			return 0;
		}

		boolean[][] isPalindrome = new boolean[s.length() + 1][s.length() + 1];
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		dp[1] = 0;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = i - 1;
			for (int j = 1; j <= i; j++) {
				// little trick here
				if (s.charAt(i - 1) == s.charAt(j - 1)
						&& (i - j < 2 || isPalindrome[j + 1][i - 1])) {
					isPalindrome[j][i] = true;
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}

		return dp[s.length()];
	}

	// Method 2: Sequence DP(from end)
	public int minCutFromBack(String s) {

		int length = s.length();
		int[] dp = new int[length + 1];
		boolean[][] isPalindrome = new boolean[length][length];

		for (int i = length; i >= 0; i--) {
			dp[i] = length - 1 - i;
			for (int j = i; j < length; j++) {
				// little trick here
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}

		return dp[0];
	}
}
