/**
 * Problem:
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
package exhaustion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 1, 2 };

		List<List<Integer>> result = permuteUnique(nums);

		for (List<Integer> path : result) {
			System.out.println(path);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];

		Arrays.sort(nums);
		dfs(result, path, used, nums);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, boolean[] used, int[] nums) {

		if (path.size() == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
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
