package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {

		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		String[] strs = { "leet", "code" };
		dict.addAll(Arrays.asList(strs));

		boolean result = wordBreak(s, dict);
		System.out.println(result);
	}

	public static boolean wordBreak(String s, Set<String> dict) {

		int length = s.length() + 1;
		boolean[] dp = new boolean[length];
		dp[0] = true;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[length - 1];
	}
}
