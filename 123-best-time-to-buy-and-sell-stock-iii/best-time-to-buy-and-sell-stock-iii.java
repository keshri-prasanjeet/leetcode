class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][2];
        return calculateProfit(prices, 0, 0, 1);
    }

    private int calculateProfit(int[] prices, int index, int holdingStatus, int transactions){
        if(index == prices.length || transactions == -1) return 0;

        if(dp[index][holdingStatus][transactions]!=null) return dp[index][holdingStatus][transactions];
        int doNothing = calculateProfit(prices, index+1, holdingStatus, transactions);
        int doSomething = 0;
        if(holdingStatus == 0){
            //if we are not holding stocks
            doSomething = -prices[index] + calculateProfit(prices, index+1, 1, transactions);
        }
        else{
            doSomething = prices[index] + calculateProfit(prices, index+1, 0, transactions-1);
        }

        return dp[index][holdingStatus][transactions] = Math.max(doSomething, doNothing);
    }
}