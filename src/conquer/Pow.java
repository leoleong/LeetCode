package conquer;

/**
 * author : leo
 * date : 2014-5-15
 * comment : 
 * �ֶ���֮+������֮
 * �ݹ�ջ������Ҫ̫��
 */
public class Pow {

	public static void main(String[] args) {

		double result = pow(0, Integer.MIN_VALUE);
		System.out.println(result);
	}

	public static double pow(double x, int n) {

		// in case of Integer.MIN_VALUE
		long expo = n;
		if (expo < 0) {
			return 1 / power(x, -expo);
		} else {
			return power(x, expo);
		}
	}

	private static double power(double base, long expo) {

		if (expo == 0) {
			return 1;
		}
		
		// use bit OP instead
		double multiplier = power(base, expo >> 1);
		if ((expo & 1) == 0) {
			return multiplier * multiplier;
		} else {
			return multiplier * multiplier * base;
		}
	}
}
