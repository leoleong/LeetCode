package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	private static int index;

	public static void main(String[] args) {

		String s = "1111";

		List<String> result = restoreIpAddresses(s);

		for (String str : result) {
			System.out.println(str);
		}
	}

	public static List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<String>();
		String[] path = new String[4];
		index = 0;

		dfs(result, path, s, 0);

		return result;
	}

	private static void dfs(List<String> result, String[] path, String s, int start) {

		int N = s.length();
		if (start == N && index==4) {
			result.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
		}
		for (int i = start; i < N; i++) {
			if (index == 4) {
				return;
			}
			if (isValid(s, start, i)) {
				path[index++] = s.substring(start, i + 1);
				dfs(result, path, s, i + 1);
				index--;
			}
		}
	}

	private static boolean isValid(String s, int start, int end) {

		if (start == end || (end - start < 3 && s.charAt(start) != '0' && Integer.parseInt(s.substring(start, end + 1)) <= 255)) {
			return true;
		}
		return false;
	}
}
