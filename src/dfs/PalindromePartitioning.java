package dfs;

import java.util.ArrayList;

public class PalindromePartitioning {

	public static void main(String[] args) {

		String s = "aab";

		ArrayList<ArrayList<String>> result = partition(s);

		for (ArrayList<String> path : result) {
			System.out.println(path.toString());
		}
	}

	public static ArrayList<ArrayList<String>> partition(String s) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();

		dfs(result, path, s, 0);

		return result;
	}

	private static void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> path, String s, int start) {

		if (start == s.length()) {
			result.add(new ArrayList<String>(path));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				path.add(s.substring(start, i + 1));
				dfs(result, path, s, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int start, int end) {

		while (start <= end && s.charAt(start) == s.charAt(end)) {
			start++;
			end--;
		}

		return start > end;
	}
}
