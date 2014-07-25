package array;

import java.util.ArrayList;
import java.util.Arrays;

public class _4Sum {

	public static void main(String[] args) {

		int[] num = new int[] { -1, -5, -5, -3, 2, 5, 0, 4 };
		System.out.println(fourSum(num, -7));
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int i, j, k, l;
		for (i = 0; i <= num.length - 4 && num[i] <= target / 4; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (j = i + 1; j < num.length; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				k = j + 1;
				l = num.length - 1;
				while (k < l) {
					if (num[i] + num[j] + num[k] + num[l] == target) {
						if (k > j + 1 && num[k] == num[k - 1]) {
							k++;
							l--;
							continue;
						}
						ArrayList<Integer> tmpList = new ArrayList<Integer>();
						tmpList.add(num[i]);
						tmpList.add(num[j]);
						tmpList.add(num[k]);
						tmpList.add(num[l]);
						list.add(tmpList);
						k++;
						l--;
					} else if (num[i] + num[j] + num[k] + num[l] < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return list;
	}

}
