/**
 * Problem:
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 * 			[2],
 * 		   [3,4],
 * 		  [6,5,7],
 * 		 [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {

		ArrayList<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		int result = minimumTotal(triangle);

		System.out.println(result);
	}

	// Method 1: Matrix DP
	public static int minimumTotal(ArrayList<List<Integer>> triangle) {

		int height = triangle.size();
		int[][] dp = new int[height][height];

		for (int i = 0; i < height; i++) {
			dp[height - 1][i] = triangle.get(height - 1).get(i);
		}

		for (int i = height - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}

		return dp[0][0];
	}

	// Method 2: Matrix DP + Rolling Array
	public static int minimumTotalWith1D(ArrayList<ArrayList<Integer>> triangle) {

		int size = triangle.size();
		Integer[] min = new Integer[size];
		triangle.get(size - 1).toArray(min);

		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
			}
		}

		return min[0];
	}
}
