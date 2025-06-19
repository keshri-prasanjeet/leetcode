class Solution {
    Integer [][] dp;
    public int maxProfit(int[] prices) {
        if(prices.length <=1) return 0;
        dp = new Integer[prices.length][2];
        return calculateProfit(prices, 0, 0);
    }

    private int calculateProfit(int[] prices, int holdingStatus, int stockIndex){
        if(stockIndex == prices.length) return 0;

        if(dp[stockIndex][holdingStatus] != null) return dp[stockIndex][holdingStatus];
        //if just hold on this index then

        int doNothing = calculateProfit(prices, holdingStatus, stockIndex+1);

        //if i want to buy or sell

        int doSomething = 0;

        if(holdingStatus == 0){
            //holding is false so buy
            doSomething = -prices[stockIndex] + calculateProfit(prices, 1, stockIndex+1);
        }
        else{
            //holding is true so sell
            doSomething = prices[stockIndex] + calculateProfit(prices, 0, stockIndex+1);
        }
        return dp[stockIndex][holdingStatus] = Math.max(doSomething, doNothing);
    }
}