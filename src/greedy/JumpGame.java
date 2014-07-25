package greedy;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * 这个算是贪心？
 */
public class JumpGame {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 3, 0, 2, 0, 2 };
		boolean result = canJump(A);
		System.out.println(result);
	}

	public static boolean canJump(int[] A) {

		int end = A.length - 1;
		int reach = 0;

		for (int i = 0; i <= reach && reach < end; i++) {
			reach = Math.max(reach, i + A[i]);
		}

		return reach >= end;
	}
}
