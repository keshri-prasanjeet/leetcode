class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); 
            //max between continue to not hold a stock and sell the current held stock and become not holding a stock
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            //max between continue to hold the stock and getting the profit until last point without holding stock and buying a stock today
        }
        return dp[n-1][0];
    }
}