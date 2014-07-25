package array;

public class PermutationSequence {

	public static void main(String[] args) {

		String s = getPermutation(9, 6);
		
		System.out.println(s);
	}

	public static String getPermutation(int n, int k) {

		StringBuilder s = new StringBuilder(n);
		int[] num = new int[n];
		int factorial = 1;
		for (int i = 0; i < n; i++) {
			factorial *= i + 1;
			num[i] = i + 1;
		}

		k--;
		for (int i = 0; i < n; i++) {
			factorial /= n - i;
			int index = k / factorial;
			s.append(num[index]);
			while (index < n - 1) {
				num[index] = num[index + 1];
				index++;
			}
			k %= factorial;
		}

		return s.toString();
	}
}
