package exhaustion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {

		int[] S = new int[] { 2, 3, 1 };
		
		List<List<Integer>> result = subsets(S);

		for (List<Integer> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<Integer>> subsets(int[] S) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(S);
		dfs(result, path, S, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, int[] S, int start) {

		result.add(new ArrayList<Integer>(path));

		for (int i = start; i < S.length; i++) {
			path.add(S[i]);
			dfs(result, path, S, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
