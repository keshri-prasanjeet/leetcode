class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][2];
        return calculateProfit(prices, 0, 0, 1);
    }

    private int calculateProfit(int[] prices, int day, int holdingStatus, int remTransactions){
        if(day==prices.length || remTransactions < 0) return 0;
        
        if (dp[day][holdingStatus][remTransactions]!= null) return dp[day][holdingStatus][remTransactions];

        int skip = calculateProfit(prices, day+1, holdingStatus, remTransactions);

        int doSomething = 0;
        if(holdingStatus == 0){
            //not holding anything
            doSomething = -prices[day] + calculateProfit(prices, day+1, 1, remTransactions);
        }
        else{
            doSomething = prices[day] + calculateProfit(prices, day+1, 0, remTransactions-1);
        }
        return dp[day][holdingStatus][remTransactions] = Math.max(doSomething, skip); 
    }
}