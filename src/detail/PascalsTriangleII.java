package detail;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {

		List<Integer> result = getRow(3);

		System.out.println(result.toString());
	}

	public static List<Integer> getRow(int rowIndex) {

		List<Integer> result = new ArrayList<Integer>();
		int[] dp = new int[rowIndex + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}

		for (int i = 2; i <= rowIndex + 1; i++) {
			// little tricks here
			for (int j = i - 2; j > 0; j--) {
				dp[j] = dp[j - 1] + dp[j];
			}
		}
		for (int i = 0; i < dp.length; i++) {
			result.add(dp[i]);
		}

		return result;
	}
}
