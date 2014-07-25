package greedy;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * 因为有扫表，所以贪心可以得到最优解？
 * 贪心根据实际情况改造可以得到最优解
 */
public class JumpGameII {

	public static void main(String[] args) {

		int[] A = new int[] { 2, 3, 1, 1, 4 };
		int result = jump(A);
		System.out.println(result);
	}

	public static int jump(int[] A) {

		int end = A.length - 1;
		int reach, lreach, step;
		reach = lreach = step = 0;

		for (int i = 0; i < end; i++) {
			reach = Math.max(reach, A[i] + i);
			if (i == lreach) {
				lreach = reach;
				step++;
			}
		}

		return step;
	}
}
