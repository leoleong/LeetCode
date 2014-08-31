/**
 * Problem:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
package greedy;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

		int[] prices = new int[] { 1, 7, 5, 4, 6, 10 };
		int result = maxProfit(prices);
		System.out.println(result);
	}

	public static int maxProfit(int[] prices) {

		// special test case
		if (prices == null || prices.length < 2) {
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
