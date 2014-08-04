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
package exhaustion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	private static String[] map;

	public static void main(String[] args) {

		String digits = "231";

		List<String> result = letterCombinations(digits);

		for (String path : result) {
			System.out.println(path);
		}
	}

	public static List<String> letterCombinations(String digits) {

		map = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();
		StringBuilder path = new StringBuilder(digits.length());

		digits = digits.replaceAll("1", "");
		dfs(result, path, digits, 0);

		return result;
	}

	private static void dfs(List<String> result, StringBuilder path, String digits, int start) {

		if (start == digits.length()) {
			result.add(path.toString());
			return;
		}
		
		int index = digits.charAt(start) - '0';
		for (int i = 0; i < map[index].length(); i++) {
			path.append(map[index].charAt(i));
			dfs(result, path, digits, start + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}
}
