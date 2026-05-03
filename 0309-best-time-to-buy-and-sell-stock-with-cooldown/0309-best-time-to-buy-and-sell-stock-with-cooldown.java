class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        //i can buy multiple times
        //if i am seeing a profit then i can sell
        //if i sell i have 1 day cooldown
        //cannot buy 2 stock in a row
        dp = new Integer[prices.length][2];
        
        return cooldownTrade(prices, 0, 0);
    }

    private int cooldownTrade(int[] prices, int index, int holdingState){
        if(index >= prices.length) return 0;
        if(dp[index][holdingState]!=null) return dp[index][holdingState];
        int doNothing = cooldownTrade(prices, index+1, holdingState);
        int doSomething = 0;
        if(holdingState == 0){
            doSomething = cooldownTrade(prices, index+1, 1) - prices[index];
        } else {
            doSomething = cooldownTrade(prices, index+2, 0) + prices[index];
        }
        return dp[index][holdingState] = Math.max(doSomething, doNothing);
    }
}