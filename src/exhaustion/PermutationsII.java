package exhaustion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 1, 1, 2 };

		List<List<Integer>> result = permuteUnique(num);

		for (List<Integer> path : result) {
			System.out.println(path);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];

		Arrays.sort(num);
		dfs(result, path, used, num);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path, boolean[] used, int[] num) {

		if (path.size() == num.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && !used[i - 1] && num[i] == num[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				path.add(num[i]);
				dfs(result, path, used, num);
				path.remove(path.size() - 1);
				used[i] = false;
			}
		}
	}
}
