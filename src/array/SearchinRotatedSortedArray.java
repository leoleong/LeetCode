package array;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

		int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		int index = search(A, 8);
		System.out.println(index);
	}

	public static int search(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == A[mid]) {
				return mid;
			}
			if (A[start] <= A[mid]) {
				// left is sorted
				if (target < A[mid] && target >= A[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// right is sorted
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}
}
