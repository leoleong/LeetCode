/**
 * Problem:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
package greedy;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {

		int[] prices = new int[] { 2, 1, 2, 0, 1 };
		int result = maxProfit(prices);
		System.out.println(result);
	}

	public static int maxProfit(int[] prices) {

		// special test case
		if (prices == null || prices.length < 2) {
			return 0;
		}

		// functional test case
		int length = prices.length;
		int[] order = new int[length];
		int[] reorder = new int[length];
		int valley = prices[0];
		int peak = prices[length - 1];
		int profit = 0;

		for (int i = 1; i < length; i++) {
			order[i] = Math.max(order[i - 1], prices[i] - valley);
			valley = Math.min(prices[i], valley);
		}
		for (int i = length - 2; i >= 0; i--) {
			reorder[i] = Math.max(reorder[i + 1], peak - prices[i]);
			peak = Math.max(prices[i], peak);
		}
		for (int i = 0; i < length; i++) {
			profit = Math.max(profit, order[i] + reorder[i]);
		}

		return profit;
	}
}
