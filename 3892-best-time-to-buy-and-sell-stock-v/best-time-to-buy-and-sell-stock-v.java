class Solution {
    Long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        int len = prices.length;
        dp = new Long[len][3][k];
        return buySellV(prices, 0, 0, k-1);
    }

    private long buySellV(int[] prices, int index, int holdingStatus, int remTrans){
        if(index == prices.length || remTrans == -1) {
            if(holdingStatus == 2) return Long.MIN_VALUE/2;
            return 0;
        }
        if(dp[index][holdingStatus][remTrans]!=null) return dp[index][holdingStatus][remTrans];
        long doNothing = buySellV(prices, index+1, holdingStatus, remTrans);
        long doSomething = 0;
        if(holdingStatus == 0){
            //can buy and can short sell
            doSomething = Math.max(
                (-prices[index] + buySellV(prices, index+1, 1, remTrans)),
                (prices[index] + buySellV(prices, index+1, 2, remTrans))
            );
        }
        else if(holdingStatus == 1){
            //alreadpy bought canot buy again
            doSomething = prices[index] + buySellV(prices, index+1, 0, remTrans-1);
        }
        else{
            //need to buy because we had short sold
            doSomething = -prices[index] + buySellV(prices, index+1, 0, remTrans-1);
        }
        return dp[index][holdingStatus][remTrans] = Math.max(doSomething, doNothing);
    }
}