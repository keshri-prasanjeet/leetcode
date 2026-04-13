class Solution {
    Integer[] dp = new Integer[45];
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n <0) return 0;
        if(dp[n]!=null) return dp[n];
        return dp[n] = climbStairs(n-2) + climbStairs(n-1);
    }
}