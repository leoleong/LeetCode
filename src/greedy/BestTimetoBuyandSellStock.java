package greedy;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

		int[] prices = new int[] { 1, 7, 5, 4, 6, 10 };
		int result = maxProfit(prices);
		System.out.println(result);
	}

	// it's more like DP instead of GREEDY
	public static int maxProfit(int[] prices) {

		// special test case
		if (prices.length < 2) {
			return 0;
		}

		// functional test case
		int min = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return profit;
	}
}
