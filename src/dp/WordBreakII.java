package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	// this test case is too tricky, couldn't pass OJ
	public static void main(String[] args) {

		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		String[] strs = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		dict.addAll(Arrays.asList(strs));

		List<String> result = wordBreak(s, dict);
		System.out.println(result);
	}

	public static ArrayList<String> wordBreak(String s, Set<String> dict) {

		int length = s.length() + 1;
		boolean[][] pos = new boolean[length][length];
		boolean[] dp = new boolean[length];
		dp[0] = true;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					pos[j][i] = true;
				}
			}
		}

		ArrayList<String> result = new ArrayList<String>();
		List<String> path = new ArrayList<String>();
		dfs(result, path, pos, s, 0);

		return result;
	}

	private static void dfs(List<String> result, List<String> path, boolean[][] pos, String s, int start) {

		int length = s.length();
		if (start == length) {
			StringBuilder sb = new StringBuilder();
			for (String str : path) {
				sb.append(str);
				sb.append(" ");
			}
			result.add(sb.toString().trim());
			return;
		}

		for (int i = start; i <= length; i++) {
			if (pos[start][i]) {
				path.add(s.substring(start, i));
				dfs(result, path, pos, s, i);
				path.remove(path.size() - 1);
			}
		}
	}
}
