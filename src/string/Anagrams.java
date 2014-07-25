package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {

	}

	public static List<String> anagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String s = new String(chars);
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(s, list);
			}
		}

		List<String> result = new ArrayList<String>();
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				result.addAll(list);
			}
		}

		return result;
	}
}
