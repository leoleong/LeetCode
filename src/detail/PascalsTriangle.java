package detail;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {

		List<List<Integer>> result = generate(5);

		for (List<Integer> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (numRows == 0) {
			return result;
		}

		List<Integer> path = new ArrayList<Integer>();
		int[] cur = new int[numRows];
		for (int i = 0; i < cur.length; i++) {
			cur[i] = 1;
		}

		// first row
		path.add(cur[0]);
		result.add(path);
		// other rows
		for (int i = 2; i <= numRows; i++) {
			path = new ArrayList<Integer>();
			path.add(cur[i - 1]);
			// little tricks here(from right to left)
			for (int j = i - 2; j > 0; j--) {
				cur[j] = cur[j - 1] + cur[j];
				path.add(cur[j]);
			}
			path.add(cur[0]);
			result.add(path);
		}

		return result;
	}
}
