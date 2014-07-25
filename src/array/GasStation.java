package array;

public class GasStation {

	public static void main(String[] args) {

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int total = 0;
		int sum = 0;
		int j = -1;
		for (int i = 0; i < cost.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				sum = 0;
				j = i;
			}
		}
		return (total < 0) ? -1 : (j + 1);
	}
}
