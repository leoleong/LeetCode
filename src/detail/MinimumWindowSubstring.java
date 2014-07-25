package detail;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		String result = minWindow("ADOBECODEBANC", "ABC");

		System.out.println(result);
	}

	public static String minWindow(String S, String T) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		String result = new String();
		int start, length, min;
		start = length = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) >= 0) {
					length++;
				}
				while (length == T.length()) {
					char sch = S.charAt(start);
					if (map.containsKey(sch)) {
						map.put(sch, map.get(sch) + 1);
						if (map.get(sch) > 0) {
							if (min > i - start + 1) {
								min = i - start + 1;
								result = S.substring(start, i + 1);
							}
							length--;
						}
					}
					start++;
				}
			}
		}

		return result;
	}
}
