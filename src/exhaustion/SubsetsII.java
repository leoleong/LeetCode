/**
 * Problem:
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * 1. Elements in a subset must be in non-descending order.
 * 2. The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 * 	[2],
 * 	[1],
 * 	[1,2,2],
 * 	[2,2],
 * 	[1,2],
 * 	[]
 * ]
 */
package exhaustion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 1, 2 };

		List<List<Integer>> result = subsetsWithDup(num);

		for (List<Integer> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(num);
		dfs(result, path, num, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, int[] num, int start) {

		result.add(new ArrayList<Integer>(path));

		for (int i = start; i < num.length; i++) {
			if (i > start && num[i] == num[i - 1]) {
				continue;
			}
			path.add(num[i]);
			dfs(result, path, num, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
