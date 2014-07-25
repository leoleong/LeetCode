package array;

import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {

		ArrayList<Integer> list = grayCode(3);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	public static ArrayList<Integer> grayCode(int n) {

		int size = 1 << n;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(i ^ (i >> 1));
		}
		return list;
	}
}
