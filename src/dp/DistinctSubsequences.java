package dp;

public class DistinctSubsequences {

	public static void main(String[] args) {

		String S = "rabbbit";
		String T = "rabbit";

		int result = numDistinct(S, T);

		System.out.println(result);
	}

	public static int numDistinct(String S, String T) {

		int column = S.length() + 1;
		int row = T.length() + 1;
		int[][] dp = new int[row][column];

		for (int j = 0; j < column; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < row; i++) {
			for (int j = i; j < column; j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}

		return dp[row - 1][column - 1];
	}
}
