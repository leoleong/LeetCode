package search;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * 二分查找变种
 */
public class SearchforaRange {

	public static void main(String[] args) {

		int[] A = new int[] { 5, 7, 7, 8, 8, 10 };
		int[] results = searchRange(A, 3);
		for (int i : results) {
			System.out.print(i + " ");
		}
	}

	public static int[] searchRange(int[] A, int target) {

		int lower, higher;

		lower = searchLowerBound(A, target);
		if (lower == -1) {
			return new int[] { -1, -1 };
		} else {
			higher = searchhigherBound(A, target);
			return new int[] { lower, higher };
		}
	}

	private static int searchLowerBound(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int bound = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				end = mid - 1;
				bound = mid;
			}
		}

		return bound;
	}

	private static int searchhigherBound(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int bound = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
				bound = mid;
			}
		}

		return bound;
	}
}
