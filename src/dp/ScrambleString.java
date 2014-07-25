package dp;

/**
 * author : leo
 * date : 2014-5-23
 * comment : 
 * DP的二分建模
 */
public class ScrambleString {

	public static void main(String[] args) {

		String s1 = "great";
		String s2 = "rgtae";
		
		boolean result = isScramble(s1, s2);
		
		System.out.println(result);
	}

	public static boolean isScramble(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		} else {
			int length = s1.length();
			if (length == 0) {
				return true;
			} else {
				boolean[][][] f = new boolean[length + 1][length][length];
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < length; j++) {
						f[1][i][j] = (s1.charAt(i) == s2.charAt(j));
					}
				}
				for (int n = 2; n <= length; n++) {
					for (int i = 0; i + n <= length; i++) {
						for (int j = 0; j + n <= length; j++) {
							for (int k = 1; k < n; k++) {
								f[n][i][j] = (f[k][i][j] && f[n - k][i + k][j + k]) 
										|| (f[k][i][j + n - k] && f[n - k][i + k][j]);
								if (f[n][i][j]) {
									break;
								}
							}
						}
					}
				}

				return f[length][0][0];
			}
		}
	}
}
