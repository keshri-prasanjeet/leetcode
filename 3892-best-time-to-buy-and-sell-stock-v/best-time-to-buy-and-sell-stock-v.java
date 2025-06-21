class Solution {
    Long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length][3][k];
        return calculateMaximumProfit(prices, 0, 0, k-1);
    }

    private long calculateMaximumProfit(int[] prices, int day, int holdingStatus, int transactions){

        if(day == prices.length || transactions == -1){
            if(holdingStatus == 2) return Long.MIN_VALUE / 2;
            return 0;
        }

        if(dp[day][holdingStatus][transactions] != null) return dp[day][holdingStatus][transactions];

        long doNothing = calculateMaximumProfit(prices, day+1, holdingStatus, transactions);
        long doSomething = 0;

        if(holdingStatus == 0){
            //not holding any stocks
            long regularBuy = (-prices[day] + calculateMaximumProfit(prices, day+1, 1, transactions));
            long shortSell =  ( prices[day] + calculateMaximumProfit(prices, day+1, 2, transactions));
            doSomething = Math.max(shortSell, regularBuy);
        }
        else if(holdingStatus == 1){
            //bought a stock
            doSomething = prices[day] + calculateMaximumProfit(prices, day+1, 0, transactions-1);
        }
        else{
            //short sold a stock
            doSomething = -prices[day] + calculateMaximumProfit(prices, day+1, 0, transactions-1);
        }
        return dp[day][holdingStatus][transactions] = Math.max(doSomething, doNothing);
    }
}