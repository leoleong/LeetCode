/**
 * Problem:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
package array;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] num = new int[] { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 };
		int result = longestConsecutive(num);
		System.out.println(result);
	}

	public static int longestConsecutive(int[] num) {

		if (num == null || num.length == 0) {
			return 0;
		}

		int longest = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		while (!set.isEmpty()) {
			Iterator<Integer> iterator = set.iterator();
			int key = iterator.next();
			set.remove(key);

			int length = 1;
			int temp = key - 1;
			while (set.contains(temp)) {
				set.remove(temp--);
				length++;
			}
			temp = key + 1;
			while (set.contains(temp)) {
				set.remove(temp++);
				length++;
			}

			if (longest < length) {
				longest = length;
			}
		}

		return longest;
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
		if (negativeBitSet.nextSetBit(0) == 0
				&& negativeBitSet.nextSetBit(1) == 1) {
			max = positiveMax + negativeMax - 1;
		} else {
			max = positiveMax + negativeMax;
		}

		return max;
	}

}
