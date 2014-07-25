package array;

import java.util.Arrays;

public class _3SumClosest {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 1, 1, 0 };
		System.out.println(threeSumClosest(num, -100));
	}

	public static int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);
		int diff = Integer.MAX_VALUE;
		int closest = 0;
		int sum = 0;
		boolean flag = false;

		int i, j, k;
		if (num.length <= 3) {
			for (int n : num) {
				closest += n;
			}
			return closest;
		}
		for (i = 0; i <= num.length - 3 && !flag; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			j = i + 1;
			k = num.length - 1;
			while (j < k) {
				sum = num[i] + num[j] + num[k];
				if (sum == target) {
					closest = target;
					flag = true;
					break;
				} else if (sum < target) {
					if (target - sum < diff) {
						diff = target - sum;
						closest = sum;
					}
					j++;
				} else {
					if (sum - target < diff) {
						diff = sum - target;
						closest = sum;
					}
					k--;
				}
			}
		}
		return closest;
	}
}
