package string;

/**
 * author : leo
 * date : 2014-5-19
 * comment : 
 * Character中有好多针对字符的函数,char为UTF-16
 */
public class ValidPalindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";

		boolean result = isPalindrome(s);

		System.out.println(result);
	}

	public static boolean isPalindrome(String s) {

		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		char lch, rch;

		while (left < right) {
			lch = s.charAt(left);
			rch = s.charAt(right);
			if (!Character.isLetterOrDigit(lch)) {
				left++;
			} else if (!Character.isLetterOrDigit(rch)) {
				right--;
			} else {
				if (lch != rch) {
					return false;
				}
				left++;
				right--;
			}
		}

		return true;
	}
}
