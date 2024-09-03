package buy_sell_two;

public class sell_two {
	public static int maxProfit(int[] prices) {
//		int maxProfit = 0;
//		int buyprice = prices[0];
//		for(int i=1;i<prices.length;i++)
//		{
//			if(prices[i] > prices[i-1])
//			{
//				maxProfit = maxProfit + (prices[i] - prices[i-1]);
//			}
//		}
//		return maxProfit;
		int n = prices.length;
        if (n == 0) return 0;

        // dp[i][0] = max profit on day i if we do not hold stock
        // dp[i][1] = max profit on day i if we hold stock
        int[][] dp = new int[n][2];

        // Base case
        dp[0][0] = 0;            // Not holding stock on the first day
        dp[0][1] = -prices[0];   // Buying stock on the first day

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); // Max profit if not holding stock
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]); // Max profit if holding stock
        }

        // The result will be the max profit without holding stock on the last day
        return dp[n-1][0];
    }
	public static void main(String args[])
	{
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}
