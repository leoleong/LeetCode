package greedy;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {

	}

	public static int maxProfit(int[] prices) {

		// special&functional test case
		int profit = 0;
		int diff;

		for (int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}

		return profit;
	}
}
