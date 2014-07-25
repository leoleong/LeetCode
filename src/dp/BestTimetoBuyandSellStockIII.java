package dp;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {

		int[] prices = new int[] { 2, 1, 2, 0, 1 };
		int result = maxProfit(prices);
		System.out.println(result);
	}

	// compare with BestTimetoBuyandSellStock
	public static int maxProfit(int[] prices) {

		int length = prices.length;

		// special test case
		if (length < 2) {
			return 0;
		}

		// functional test case
		int[] order = new int[length];
		int[] reverse = new int[length];
		int valley = prices[0];
		int peak = prices[length - 1];
		int profit = 0;

		for (int i = 1; i < length; i++) {
			order[i] = Math.max(order[i - 1], prices[i] - valley);
			valley = Math.min(prices[i], valley);
		}
		for (int i = length - 2; i >= 0; i--) {
			reverse[i] = Math.max(reverse[i + 1], peak - prices[i]);
			peak = Math.max(prices[i], peak);
		}
		for (int i = 0; i < length; i++) {
			profit = Math.max(profit, order[i] + reverse[i]);
		}

		return profit;
	}
}
