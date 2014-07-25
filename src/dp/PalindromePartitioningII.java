package dp;

/**
 * author : leo
 * date : 2014-5-22
 * comment : 
 * 增加extra元素,化简情况,最后需要去除
 */
public class PalindromePartitioningII {

	public static void main(String[] args) {

		String s = "abb";

		int result = minCut(s);

		System.out.println(result);
	}

	public static int minCut(String s) {

		int length = s.length();
		// add extra element
		int[] dp = new int[length + 1];
		boolean[][] matrix = new boolean[length][length];

		for (int i = length; i >= 0; i--) {
			dp[i] = length - 1 - i;
			for (int j = i; j < length; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || matrix[i + 1][j - 1])) {
					matrix[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}

		return dp[0];
	}
}
