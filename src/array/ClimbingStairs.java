package array;

public class ClimbingStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(44));
	}

	// recursion : TLE
	/*public static int climbStairs(int n) {

		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}*/

	// iteration : pass(like DP more or less)
	public static int climbStairs(int n) {

		int prev = 0;
		int cur = 1;
		int tmp;
		
		for (int i = 1; i <= n; i++) {
			tmp = prev + cur;
			prev = cur;
			cur = tmp;
		}
		
		return cur;
	}
}
