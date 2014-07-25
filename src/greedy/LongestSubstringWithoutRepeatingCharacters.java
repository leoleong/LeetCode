package greedy;

import java.util.HashMap;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * 或者用array替换hashmap
 * 关键是alpha和position之间的映射
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch) && map.get(ch) >= start) {
				start = map.get(ch) + 1;
			}
			map.put(ch, i);
			length = Math.max(length, i - start + 1);
		}

		return length;
	}
}
