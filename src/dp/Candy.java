/**
 * Problem:
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * 	- Each child must have at least one candy.
 * 	- Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
package dp;

public class Candy {

	public static void main(String[] args) {

		int[] ratings = new int[] { 1, 2, 3, 4, 4, 3, 1, 4 };
		int result = candy(ratings);
		System.out.println(result);
	}

	public static int candy(int[] ratings) {

		int[] left = new int[ratings.length];
		left[0] = 1;
		int[] right = new int[ratings.length];
		right[ratings.length - 1] = 1;
		int result = 0;

		for (int i = 1; i < ratings.length; i++) {
			left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
		}
		for (int i = 0; i < ratings.length; i++) {
			result += Math.max(left[i], right[i]);
		}

		return result;
	}
}
