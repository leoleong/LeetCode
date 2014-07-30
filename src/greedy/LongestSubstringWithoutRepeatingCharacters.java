/**
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters. 
 * 
 * For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Note:
 * It also could use array instead of HashMap.
 */
package greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
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
