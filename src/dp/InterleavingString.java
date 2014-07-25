package dp;

/**
 * author : leo
 * date : 2014-5-23
 * comment :
 * 注意长度不相等的情况 
 */
public class InterleavingString {

	public static void main(String[] args) {

		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		boolean result = isInterleave(s1, s2, s3);

		System.out.println(result);
	}

	public static boolean isInterleave(String s1, String s2, String s3) {

		int row = s1.length() + 1;
		int column = s2.length() + 1;
		if (row + column - 2 != s3.length()) {
			return false;
		} else {
			boolean[][] f = new boolean[row][column];
			f[0][0] = true;

			for (int i = 1; i < row; i++) {
				f[i][0] = f[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
			}
			for (int j = 1; j < column; j++) {
				f[0][j] = f[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
			}
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < column; j++) {
					f[i][j] = (f[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
							|| (f[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
				}
			}

			return f[row - 1][column - 1];
		}
	}
}
