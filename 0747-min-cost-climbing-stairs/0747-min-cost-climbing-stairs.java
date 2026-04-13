class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int len = cost.length;
        for(int i=2;i<cost.length;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}