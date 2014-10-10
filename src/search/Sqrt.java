/**
 * Problem:
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
package search;

public class Sqrt {

	public static void main(String[] args) {

		int result = sqrt(5);
		System.out.println(result);
	}

	public static int sqrt(int x) {

		if (x < 2) {
			return x;
		}
		
		int left = 1;
		int right = x;
		int mid, value;
		int sqrt = 1;
		
		while (left <= right) {
			mid = (left + right) / 2;
			value = x / mid;
			if (value < mid) {
				right = mid - 1;
			} else if (value > mid) {
				left = mid + 1;
				sqrt = mid;
			} else {
				return mid;
			}
		}

		return sqrt;
	}
}
