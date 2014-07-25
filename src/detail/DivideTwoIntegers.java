package detail;

public class DivideTwoIntegers {

	public static void main(String[] args) {

		int result = divide_1(-2147483648, 1);

		System.out.println(result);
	}

	// -----------------------------------------------------------------
	// time:O(n), TLE
	public static int divide(int dividend, int divisor) {

		int sign = dividend * divisor >= 0 ? 1 : -1;
		int result = 0;
		long a = Math.abs(dividend);
		long b = Math.abs(divisor);

		while (a >= b) {
			result++;
			a -= b;
		}

		return sign * result;
	}

	// -----------------------------------------------------------------
	// time:O(logn), pass
	public static int divide_1(int dividend, int divisor) {

		int sign = (dividend ^ divisor) >> 31 == 0 ? 1 : -1;
		long result = 0;
		// little trick here
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		while (a >= b) {
			long c = b;
			// little trick here
			for (int i = 0; a >= c; i++, c <<= 1) {
				a -= c;
				result += 1 << i;
			}
		}

		return (int) (sign * result);
	}
}
