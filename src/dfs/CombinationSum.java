package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

		int[] candidates = new int[] { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> result = combinationSum(candidates, target);

		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(candidates);
		dfs(result, path, candidates, target, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int start) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i]) {
				return;
			}
			path.add(candidates[i]);
			dfs(result, path, candidates, target - candidates[i], i);
			path.remove(path.size() - 1);
		}
	}
}
