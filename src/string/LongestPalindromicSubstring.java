package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

		String result = longestPalindrome(s);

		System.out.println(result);
	}

	// time:O(n^2) space:O(n^2)
	public static String longestPalindrome(String s) {

		int length = s.length();
		boolean[][] dp = new boolean[length][length];
		int start, len;
		start = len = 0;

		for (int i = 0; i < length; i++) {
			dp[i][i] = true;
			for (int j = 0; j < i; j++) {
				if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
					if (i - j > len) {
						start = j;
						len = i - j;
					}
				}
			}
		}

		return s.substring(start, start + len + 1);
	}
}
