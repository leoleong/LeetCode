package array;

import java.util.BitSet;
import java.util.HashMap;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] num = new int[] { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 };
		System.out.println(longestConsecutive(num));
	}

	public static int longestConsecutive(int[] num) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>(num.length);
		for (int i : num) {
			map.put(i, false);
		}

		int max = 0;
		int tmpMax = 1;
		for (int key : map.keySet()) {
			if (!map.get(key)) {
				map.put(key, true);
				int initialKey = key;
				key = initialKey - 1;
				while (map.containsKey(key)) {
					map.put(key, true);
					tmpMax += 1;
					key--;
				}
				key = initialKey + 1;
				while (map.containsKey(key)) {
					map.put(key, true);
					tmpMax += 1;
					key++;
				}
				if (max < tmpMax) {
					max = tmpMax;
				}
				tmpMax = 1;
			}
		}
		return max;
	}

	// bitset solution
	public static int bitSetLongestConsecutive(int[] num) {
		BitSet positiveBitSet = new BitSet();
		BitSet negativeBitSet = new BitSet();

		for (int i : num) {
			if (i >= 0) {
				positiveBitSet.set(i);
			} else {
				negativeBitSet.set(-i);
			}

		}

		int preIndex = 0;
		int index;
		int positiveMax = 0;
		int negativeMax = 0;
		int tmpMax = 1;
		int max;
		while ((index = positiveBitSet.nextSetBit(preIndex)) != -1) {
			if (index == preIndex) {
				tmpMax += 1;
			} else {
				if (positiveMax < tmpMax) {
					positiveMax = tmpMax;
				}
				tmpMax = 1;
				preIndex = index;
			}
			preIndex++;
		}

		preIndex = 0;
		while ((index = negativeBitSet.nextSetBit(preIndex)) != -1) {
			if (index == preIndex) {
				tmpMax += 1;
			} else {
				if (negativeMax < tmpMax) {
					negativeMax = tmpMax;
				}
				tmpMax = 1;
				preIndex = index;
			}
			preIndex++;
		}
		if (negativeBitSet.nextSetBit(0) == 0 && negativeBitSet.nextSetBit(1) == 1) {
			max = positiveMax + negativeMax - 1;
		} else {
			max = positiveMax + negativeMax;
		}

		return max;
	}

}
