class Solution {
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length][2][k+1];
        return calculateMaxProfit(prices, 0, 0, k);
    }

    private int calculateMaxProfit(int[] prices, int index, int holdingStatus, int transactions){
        if(prices.length == index || transactions==0) return 0;
        if(dp[index][holdingStatus][transactions]!=null) return dp[index][holdingStatus][transactions];
        int doNothing = calculateMaxProfit(prices, index+1, holdingStatus, transactions);
        int doSomething = 0;
        if(holdingStatus == 0){
            doSomething = -prices[index] + calculateMaxProfit(prices, index+1, 1, transactions);
        }
        else{
            doSomething = prices[index] + calculateMaxProfit(prices, index+1, 0, transactions-1);
        }
        return dp[index][holdingStatus][transactions] = Math.max(doSomething, doNothing);
    }
}