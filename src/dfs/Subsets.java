/**
 * Problem:
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 1. Elements in a subset must be in non-descending order.
 * 2. The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 * 	[3],
 * 	[1],
 * 	[2],
 * 	[1,2,3],
 * 	[1,3],
 * 	[2,3],
 * 	[1,2],
 * 	[]
 * ]
 */
package dfs;

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
		if (S == null || S.length == 0) {
			return result;
		}

		List<Integer> path = new ArrayList<Integer>();

		// non-descending order
		Arrays.sort(S);
		dfs(result, path, S, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path,
			int[] S, int start) {

		result.add(new ArrayList<Integer>(path));

		for (int i = start; i < S.length; i++) {
			path.add(S[i]);
			dfs(result, path, S, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
