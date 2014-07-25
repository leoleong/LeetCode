package exhaustion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {

		List<List<Integer>> result = combine(4, 2);
		
		for (List<Integer> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		dfs(result, path, 1, n, k);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, int start, int n, int k) {

		if (path.size() == k) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = start; i <= n; i++) {
			path.add(i);
			dfs(result, path, i + 1, n, k);
			path.remove(path.size() - 1);
		}
	}
}
