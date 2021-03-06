/**
 * Problem:
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Solution:
 * There are 2 ways to solve this problem:
 * 1. sort + dfs (realized)
 * 2. count + dfs
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {

		int[] nums = new int[] { 7, 8, 9 };

		List<List<Integer>> result = permute(nums);

		for (List<Integer> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> path = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];

		dfs(result, path, used, nums);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path,
			boolean[] used, int[] nums) {

		if (path.size() == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				path.add(nums[i]);
				dfs(result, path, used, nums);
				path.remove(path.size() - 1);
				used[i] = false;
			}
		}
	}
}
