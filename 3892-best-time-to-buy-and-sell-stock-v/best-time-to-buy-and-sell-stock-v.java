class Solution {
    Long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length][3][k];
        return calculateMaxProfit(prices, 0, 0, k-1);
    }

    private long calculateMaxProfit(int[] prices, int day, int holdingStatus, int transactions){

        if(prices.length == day || transactions < 0) {
            //must close the position that are still open but the days have exhausted
            if(holdingStatus == 1) return Long.MIN_VALUE /2;
            if(holdingStatus == 2) return Long.MIN_VALUE /2;
            return 0;
        }
        if(dp[day][holdingStatus][transactions]!=null) return dp[day][holdingStatus][transactions];
        // System.out.println("day is " + day);
        long doNothing = calculateMaxProfit(prices, day+1, holdingStatus, transactions);

        long doSomething =0;
        if(holdingStatus == 0){
            //i dont hold any stocks
            //however i can short sell or normal buy
            // System.out.println("holding status was 0");
            doSomething = Math.max(prices[day] + calculateMaxProfit(prices, day+1, 2, transactions),
                                    -prices[day] + calculateMaxProfit(prices, day+1, 1, transactions));
                                    //max between short selling and normal buying
        }
        else if(holdingStatus == 1){
            // System.out.println("holding status was 1");
            //i did a normal buy and i hold a stock currently, so sell
            doSomething = prices[day] + calculateMaxProfit(prices, day+1, 0, transactions-1);//normal sell since i hold a stock
        }
        else{
            // System.out.println("holding status was 2");
            //i short sold and got here so i gotta buy
            doSomething = -prices[day] + calculateMaxProfit(prices, day+1, 0, transactions-1);
        }
        // System.out.println("Do nothing " + doNothing + ", do something " + doSomething);
        return dp[day][holdingStatus][transactions]=Math.max(doNothing, doSomething);
    }
}