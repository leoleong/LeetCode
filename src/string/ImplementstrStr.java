/**
 * Problem:
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
package string;

public class ImplementstrStr {

	public static void main(String[] args) {

		String haystack = "123456789";
		String needle = "45";

		String result = strStr(haystack, needle);

		System.out.println(result);
	}

	public static String strStr(String haystack, String needle) {

		if (haystack == null || needle == null || needle.length() == 0) {
			return haystack;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean match = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					match = false;
					break;
				}
			}

			if (match) {
				return haystack.substring(i);
			}
		}

		return null;
	}
}
