/**
 * Problem:
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
 * and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. 
 * (order does not matter).
 */
package detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {

		String S = "abaababbaba";
		String[] L = { "ab", "ba", "ab", "ba" };
		ArrayList<Integer> result = findSubstring(S, L);
		System.out.println(result);
	}

	public static ArrayList<Integer> findSubstring(String S, String[] L) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String l : L) {
			if (map.containsKey(l)) {
				map.put(l, map.get(l) + 1);
			} else {
				map.put(l, 1);
			}
		}

		int word = L[0].length();
		for (int i = 0; i < L[0].length(); i++) {
			Map<String, Integer> temp = new HashMap<String, Integer>(map);
			int count = 0;
			int start = i;
			for (int j = i; j <= S.length() - word; j += word) {
				String r = S.substring(j, j + word);
				if (temp.containsKey(r)) {
					temp.put(r, temp.get(r) - 1);
					if (temp.get(r) >= 0) {
						count++;
					}
					while (count == L.length) {
						String l = S.substring(start, start + word);
						if (temp.containsKey(l)) {
							temp.put(l, temp.get(l) + 1);
							if (temp.get(l) > 0) {
								if (j - start == word * (L.length - 1)) {
									result.add(start);
								}
								count--;
							}
						}
						start += word;
					}
				}
			}
		}

		return result;
	}
}
