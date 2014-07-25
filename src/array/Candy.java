package array;

public class Candy {

	public static void main(String[] args) {

		int[] ratings = new int[] { 1, 2, 3, 4, 4, 3, 1, 4 };
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {

		int length = ratings.length;
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] = 1;
		right[length - 1] = 1;

		for (int i = 1; i < length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			} else {
				left[i] = 1;
			}
		}
		for (int i = length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				right[i] = 1;
			}
		}

		int count = 0;
		for (int i = 0; i < length; i++) {
			count += Math.max(left[i], right[i]);
		}

		return count;
	}
}
