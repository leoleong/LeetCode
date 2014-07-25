package string;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	public static void main(String[] args) {

		int result = romanToInt("MMCMXLIX");

		System.out.println(result);
	}

	public static int romanToInt(String s) {

		int[] radix = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbol = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < symbol.length; i++) {
			map.put(symbol[i], radix[i]);
		}
		int num = 0;

		for (int i = 0; i < s.length();) {
			if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
				num += map.get(s.substring(i, i + 2));
				i += 2;
			} else {
				num += map.get(s.substring(i, i + 1));
				i++;
			}
		}

		return num;
	}
}
