package detail;

public class ReverseInteger {

	public static void main(String[] args) {

		int result = reverse(-101);

		System.out.println(result);
	}

	public static int reverse(int x) {

		int symbol = x > 0 ? 1 : -1;
		x = Math.abs(x);
		int r = 0;
		
		for (; x > 0; x /= 10) {
			r = r * 10 + x % 10;
		}

		return symbol > 0 ? r : -r;
	}
}
