class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];
        for(int day=n-1;day>-1;day--){
            for(int holding=0;holding<2;holding++){
                for(int transaction=1;transaction<=2;transaction++){
                    if(holding == 0){
                        dp[day][0][transaction] = Math.max(
                            -prices[day] + dp[day+1][1][transaction],
                            dp[day+1][0][transaction]
                        );
                    }
                    else{
                        dp[day][1][transaction] = Math.max(
                            prices[day] + dp[day+1][0][transaction-1],
                            dp[day+1][1][transaction]
                        );
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}