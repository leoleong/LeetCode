/**
 * Problem:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {

		String s = "1111";

		List<String> result = restoreIpAddresses(s);

		System.out.println(result);
	}

	public static List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<String>();
		List<String> path = new ArrayList<String>();

		dfs(result, path, s, 0);

		return result;
	}

	private static void dfs(List<String> result, List<String> path, String s,
			int start) {

		if (path.size() == 4 && start == s.length()) {
			result.add(path.get(0) + "." + path.get(1) + "." + path.get(2)
					+ "." + path.get(3));
		}

		if (path.size() >= 4) {
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isValid(s, start, i)) {
				path.add(s.substring(start, i + 1));
				dfs(result, path, s, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private static boolean isValid(String s, int start, int end) {

		if (start == end
				|| (end - start < 3 && s.charAt(start) != '0' && Integer
						.parseInt(s.substring(start, end + 1)) <= 255)) {
			return true;
		}

		return false;
	}
}
