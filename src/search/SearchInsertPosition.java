package search;

/**
 * author : leo
 * date : 2014-5-16
 * comment : 
 * 二分查找变种，添加额外记录量
 */
public class SearchInsertPosition {

	public static void main(String[] args) {

		int[] A = new int[] { 1, 3, 5, 6 };
		int result = searchInsert(A, 0);
		System.out.println(result);
	}

	public static int searchInsert(int[] A, int target) {

		int start = 0;
		int end = A.length - 1;
		int index = 0;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
				index = start;
			} else if (A[mid] > target) {
				end = mid - 1;
				// a little trick here
				index = mid;
			} else {
				index = mid;
				break;
			}
		}

		return index;
	}
}
