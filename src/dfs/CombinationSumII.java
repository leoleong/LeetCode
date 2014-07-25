package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {

		int[] num = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		List<List<Integer>> result = combinationSum2(num, target);

		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> combinationSum2(int[] num, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(num);
		dfs(result, path, num, target, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, int[] num, int target, int start) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = start; i < num.length; i++) {
			if (i > start && num[i] == num[i - 1]) {
				continue;
			}
			if (target < num[i]) {
				return;
			}
			path.add(num[i]);
			dfs(result, path, num, target - num[i], i + 1);
			path.remove(path.size() - 1);
		}
	}
}
