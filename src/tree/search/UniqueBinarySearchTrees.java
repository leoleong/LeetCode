package tree.search;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {

		int result = numTrees(3);
		
		System.out.println(result);
	}

	public static int numTrees(int n) {

		if (n < 2) {
			return 1;
		}
		
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[i - j] * dp[j - 1];
			}
		}

		return dp[n];
	}
}
