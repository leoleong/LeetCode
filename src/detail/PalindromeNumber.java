package detail;

public class PalindromeNumber {

	public static void main(String[] args) {

		boolean result = isPalindrome(1111);

		System.out.println(result);
	}

	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}
		
		int d = 1;
		while (x / d >= 10) {
			d *= 10;
		}
		while (x > 0) {
			int front = x / d;
			int back = x % 10;
			if (front != back) {
				return false;
			}
			x = x % d / 10;
			d /= 100;
		}

		return true;
	}
}
