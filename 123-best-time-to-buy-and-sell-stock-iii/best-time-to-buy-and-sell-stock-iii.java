class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        dp = new Integer[len][2][2];
        return buySell(prices, 0, 0, 1);
    }
    private int buySell(int[] prices, int index, int holdingStatus, int remTrans){
        if(index == prices.length) return 0;
        if(remTrans == -1) return 0;
        if(dp[index][holdingStatus][remTrans]!=null) return dp[index][holdingStatus][remTrans];
        int doNothing = buySell(prices, index+1, holdingStatus, remTrans);
        int doSomething = 0;
        if(holdingStatus == 0){
            doSomething = -prices[index] + buySell(prices, index+1, 1, remTrans);
        }
        else{
            doSomething = prices[index] + buySell(prices, index+1, 0, remTrans-1);
        }
        return dp[index][holdingStatus][remTrans] = Math.max(doSomething, doNothing);
    }
}