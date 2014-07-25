package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : leo
 * date : 2014-5-22
 * comment : 
 * Arrays.asList()--Collection.toArray()之间的转换
 * 两种做法:1.修改原数据; 2.不修改原数据
 */
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

	public static int minimumTotal(ArrayList<List<Integer>> triangle) {

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
