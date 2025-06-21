class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        //can do normal buy sell but attach a fee to each
        dp = new Integer[prices.length][2];
        return calculateMaximumProfit(prices, 0, 0, fee);
    }
    private int calculateMaximumProfit(int[] prices, int day, int holdingStatus, int fee){
        if(prices.length == day) return 0;
        if(dp[day][holdingStatus]!=null) return dp[day][holdingStatus];
        int doNothing = calculateMaximumProfit(prices, day+1, holdingStatus, fee);
        int doSomething;
        if(holdingStatus == 0){
            //we are not holding any stock
            doSomething = -prices[day] + calculateMaximumProfit(prices, day+1, 1, fee);
        }
        else{
            doSomething = prices[day] + calculateMaximumProfit(prices, day+1, 0, fee) -fee;
            //we are holding a stock
        }
        return dp[day][holdingStatus] = Math.max(doSomething, doNothing);
    }
}