package array;

public class SingleNumber {

	public static void main(String[] args) {

	}

	public int singleNumber(int[] A) {
		int b = 0;
		for (int a : A) {
			b ^= a;
		}
		return b;
	}

}
