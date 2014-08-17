/**
 * Problem:
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
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

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= i; j++) {
				if (dict.contains(s.substring(j - 1, i)) && dp[j - 1]) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
}
