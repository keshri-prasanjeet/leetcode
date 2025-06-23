class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return buySell(prices, 0, 0);
    }

    private int buySell(int[] prices, int holdingStatus, int index){
        if(index == prices.length) return 0;
        if(dp[index][holdingStatus]!=null) return dp[index][holdingStatus];
        int doNothing = buySell(prices, holdingStatus, index+1);
        int doSomething = 0;
        if(holdingStatus == 0){
            doSomething += -prices[index] + buySell(prices, 1, index+1);
        }
        else{
            doSomething += prices[index] + buySell(prices, 0, index+1);
        }
        return dp[index][holdingStatus] = Math.max(doSomething, doNothing);
    }
}