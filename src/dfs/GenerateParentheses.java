/**
 * Problem:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {

		List<String> result = generateParenthesis(3);

		System.out.println(result);
	}

	public static List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<String>();

		dfs(result, "", n, 0, 0);

		return result;
	}

	private static void dfs(List<String> result, String path, int size,
			int left, int right) {

		if (left < right) {
			return;
		}
		if (left == size && right == size) {
			result.add(path);
			return;
		}

		if (left < size) {
			dfs(result, path + "(", size, left + 1, right);
		}
		if (right < size) {
			dfs(result, path + ")", size, left, right + 1);
		}
	}
}
