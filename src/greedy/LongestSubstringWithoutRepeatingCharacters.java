package greedy;

import java.util.HashMap;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * ������array�滻hashmap
 * �ؼ���alpha��position֮���ӳ��
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
