/**
 * Problem:
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * 	- Only one letter can be changed at a time
 * 	- Each intermediate word must exist in the dictionary
 * 
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 	- Return 0 if there is no such transformation sequence.
 * 	- All words have the same length.
 * 	- All words contain only lowercase alphabetic characters.
 */
package bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {

		String start = "qa";
		String end = "sq";
		Set<String> dict = new HashSet<String>();
		String[] strings = new String[] { "si", "go", "se", "cm", "so", "ph",
				"mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm",
				"ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo",
				"ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or",
				"rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
				"nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co",
				"ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
				"os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er",
				"sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm",
				"ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
		for (String string : strings) {
			dict.add(string);
		}

		int result = ladderLength(start, end, dict);

		System.out.println(result);
	}

	public static int ladderLength(String start, String end, Set<String> dict) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		Queue<String> queue = new ArrayDeque<String>();

		queue.offer(start);
		map.put(start, 1);
		while (!queue.isEmpty()) {
			String current = queue.poll();
			int level = map.get(current);
			for (int i = 0; i < current.length(); i++) {
				StringBuilder sb = new StringBuilder(current);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (current.charAt(i) == ch) {
						continue;
					}
					sb.setCharAt(i, ch);
					String str = sb.toString();
					if (str.equals(end)) {
						return level + 1;
					}
					if (dict.contains(str) && !map.containsKey(str)) {
						queue.offer(str);
						map.put(str, level + 1);
					}
				}
			}
		}

		return 0;
	}
}
