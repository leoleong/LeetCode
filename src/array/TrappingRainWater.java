package array;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * Á½±ßÉ¨±í
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] A = new int[] { 2, 0, 2 };
		int result = trap(A);
		System.out.println(result);
	}

	public static int trap(int[] A) {

		int length = A.length;
		
		if (length <= 2) {
			return 0;
		} else {
			int[] lmax = new int[length];
			int[] rmax = new int[length];
			lmax[0] = A[0];
			rmax[length - 1] = A[length - 1];

			for (int i = 1; i < length; i++) {
				lmax[i] = Math.max(lmax[i - 1], A[i]);
			}
			for (int i = length - 2; i >= 0; i--) {
				rmax[i] = Math.max(rmax[i + 1], A[i]);
			}

			int count = 0;
			for (int i = 1; i < length - 1; i++) {
				int min = Math.min(lmax[i], rmax[i]);
				if (A[i] < min) {
					count += min - A[i];
				}
			}
			return count;
		}
	}
}
