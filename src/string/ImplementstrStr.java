package string;

/**
 * author : leo 
 * date : 2014-5-20 
 * comment : 
 * 暴力破解，仍可以优化
 */
public class ImplementstrStr {

	public static void main(String[] args) {

		String haystack = "123456789";
		String needle = "45";

		String result = strStr(haystack, needle);

		System.out.println(result);
	}

	public static String strStr(String haystack, String needle) {

		int hlength = haystack.length();
		int nlength = needle.length();
		boolean isMatch;

		if (nlength == 0) {
			return haystack;
		} else {
			for (int i = 0; i <= hlength - nlength; i++) {
				isMatch = true;
				for (int j = 0, prev = i; j < nlength;) {
					if (haystack.charAt(prev++) != needle.charAt(j++)) {
						isMatch = false;
						break;
					}
				}

				if (isMatch) {
					return haystack.substring(i);
				}
			}

			return null;
		}
	}
}
