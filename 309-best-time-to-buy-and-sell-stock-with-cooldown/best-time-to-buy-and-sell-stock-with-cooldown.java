class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        //one day of cooldown
        int len = prices.length;
        dp = new Integer[len][2];
        return buySell(prices, 0, 0);
    }

    private int buySell(int[] prices, int index, int holdingStatus){
        if(index >= prices.length) return 0;
        if(dp[index][holdingStatus]!=null) return dp[index][holdingStatus];
        int doNothing = buySell(prices, index+1, holdingStatus);
        int doSomething = 0;
        if(holdingStatus == 0){
            doSomething = -prices[index] + buySell(prices, index+1, 1);
        }
        else{
            doSomething = prices[index] + buySell(prices, index+2, 0);
        }
        return dp[index][holdingStatus] = Math.max(doSomething, doNothing);
    }
}