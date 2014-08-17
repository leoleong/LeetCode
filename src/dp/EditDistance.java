/**
 * Problem:
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * 	a) Insert a character
 * 	b) Delete a character
 * 	c) Replace a character
 */
package dp;

public class EditDistance {

	public static void main(String[] args) {

		String word1 = "abc";
		String word2 = "bc";
		int result = minDistance(word1, word2);
		System.out.println(result);
	}

	public static int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),
							dp[i - 1][j - 1]) + 1;
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
