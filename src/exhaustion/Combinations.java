/**
 * Problem:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * 	[2,4],
 * 	[3,4],
 * 	[2,3],
 * 	[1,2],
 * 	[1,3],
 * 	[1,4],
 * ]
 */
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
