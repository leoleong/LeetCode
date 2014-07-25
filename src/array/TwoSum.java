package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TwoSum {

	public static void main(String[] args) {

		int[] numbers = new int[] { 3, 2, 4 };
		int target = 6;
		int[] pair = twoSum(numbers, target);
		System.out.println(Arrays.toString(pair));
	}

	public static int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>(numbers.length);
		int[] pair = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			LinkedList<Integer> list;
			if (map.containsKey(numbers[i])) {
				list = map.get(numbers[i]);
			} else {
				list = new LinkedList<Integer>();
			}
			list.add(i + 1);
			map.put(numbers[i], list);
		}
		int other;
		for (int i : map.keySet()) {
			other = target - i;
			if (map.containsKey(other)) {
				if (i == other && map.get(i).size() > 1) {
					pair[0] = map.get(i).getFirst();
					pair[1] = map.get(other).getLast();
				} else {
					pair[0] = map.get(i).getFirst();
					pair[1] = map.get(other).getFirst();
				}

				if (pair[0] > pair[1]) {
					pair[0] = pair[0] ^ pair[1];
					pair[1] = pair[0] ^ pair[1];
					pair[0] = pair[0] ^ pair[1];
				}
				break;
			}
		}

		return pair;
	}

}
