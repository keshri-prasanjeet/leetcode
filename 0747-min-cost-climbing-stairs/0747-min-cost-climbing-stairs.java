class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length+1];
        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }

    private int minCost(int[] cost, int index){
        if(index >= cost.length) return 0;
        if(dp[index]!=null) return dp[index];
        int cur = cost[index] + Math.min(minCost(cost, index+1),minCost(cost, index+2));
        return dp[index] = cur;
    }
}