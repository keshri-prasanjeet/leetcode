class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return calculateMaxProfit(prices, 0, 0);
    }

    private int calculateMaxProfit(int[] prices, int index, int holdingStatus){
        if(index == prices.length) return 0;
        if(dp[index][holdingStatus]!=null) return dp[index][holdingStatus];
        int doNothing = calculateMaxProfit(prices, index+1, holdingStatus);

        int doSomething = 0;

        if(holdingStatus == 0){
            //holding nothing, lets hold a stock
            doSomething = -prices[index] + calculateMaxProfit(prices, index+1, 1);
        }
        else{
            //holding a stock, let try to sell it
            doSomething = prices[index] + calculateMaxProfit(prices, index+1, 0);
        }

        return dp[index][holdingStatus] = Math.max(doSomething, doNothing);
    }
}