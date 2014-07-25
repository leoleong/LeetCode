package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _3Sum {

	public static void main(String[] args) {

		int[] num = new int[] { 0, 0, 0 };
		System.out.println(threeSum(num));
	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int i, j, k;
		for (i = 0; i <= num.length - 3 && num[i] <= 0; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			j = i + 1;
			k = num.length - 1;
			while (j < k) {
				if (num[i] + num[j] + num[k] == 0) {
					if (j >= i + 2 && num[j] == num[j - 1]) {
						j++;
						k--;
						continue;
					}
					ArrayList<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[i]);
					tmpList.add(num[j]);
					tmpList.add(num[k]);
					list.add(tmpList);
					j++;
					k--;
				} else if (num[i] + num[j] + num[k] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return list;
	}

	public static ArrayList<ArrayList<Integer>> hashThreeSum(int[] num) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return list;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(num.length);
		for (int i : num) {
			if (map.containsKey(i)) {
				int value = map.get(i) + 1;
				map.put(i, value);
			} else {
				map.put(i, 1);
			}
		}

		Arrays.sort(num);

		boolean endFlag = false;
		boolean case1, case2, case3;
		ArrayList<Integer> tmpList = new ArrayList<Integer>(3);
		for (int i = 0; i < num.length; i++) {
			if (endFlag) {
				break;
			}
			for (int j = i + 1; j < num.length; j++) {
				int addend1 = num[i];
				int addend2 = num[j];
				int target = 0 - (addend1 + addend2);
				if (target < 0) {
					endFlag = true;
					break;
				} else if (addend2 > -addend1 / 2) {
					break;
				}
				if (map.containsKey(target)) {
					case1 = (target == addend1 && target == addend2 && map.get(target) >= 3);
					case2 = (target == addend1 || target == addend2) && map.get(target) >= 2;
					case3 = (target != addend1 && target != addend2);
					if (case1 || case2 || case3) {
						tmpList.clear();
						tmpList.add(addend1);
						tmpList.add(addend2);
						tmpList.add(target);
						if (!list.contains(tmpList)) {
							list.add(tmpList);
						}
					}
				}
			}
		}
		return list;
	}
}
