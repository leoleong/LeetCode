package array;

public class SingleNumberII {

	public static void main(String[] args) {

	}

	public int singleNumber(int[] A) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int val = 0;
			for (int a : A) {
				val += (a >> i) & 1;
			}
			result += (val % 3) << i;
		}
		return result;
	}
}
