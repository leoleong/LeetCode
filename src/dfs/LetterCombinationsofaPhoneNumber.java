/**
 * Problem:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

		String digits = "231";

		List<String> result = letterCombinations(digits);

		for (String path : result) {
			System.out.println(path);
		}
	}

	public static List<String> letterCombinations(String digits) {

		String[] map = new String[] { " ", "", "abc", "def", "ghi", "jkl",
				"mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();
		StringBuilder path = new StringBuilder(digits.length());

		digits = digits.replaceAll("1", "");
		dfs(result, path, map, digits, 0);

		return result;
	}

	private static void dfs(List<String> result, StringBuilder path,
			String[] map, String digits, int start) {

		if (start == digits.length()) {
			result.add(path.toString());
			return;
		}

		int index = digits.charAt(start) - '0';
		String str = map[index];
		for (int i = 0; i < str.length(); i++) {
			path.append(str.charAt(i));
			dfs(result, path, map, digits, start + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}
}
