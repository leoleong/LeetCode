package array;

public class RemoveElement {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 3, 4 };
		System.out.println(removeElement(A, 3));
	}

	public static int removeElement(int[] A, int elem) {

		int count = 0;
		for (int i : A) {
			if (i != elem) {
				A[count++] = i;
			}
		}
		return count;
	}
}
