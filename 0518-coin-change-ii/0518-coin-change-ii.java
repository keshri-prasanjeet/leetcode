class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[amount+1][coins.length];
        return doCoinChange(amount, coins, 0);
    }

    private int doCoinChange(int target, int[] coins, int idx){
        if(target == 0) return 1;
        if(target < 0 || idx >= coins.length) return 0;
        if(dp[target][idx]!=null) return dp[target][idx];
        int take = doCoinChange(target - coins[idx], coins, idx);
        int skip = doCoinChange(target, coins, idx+1);
        return dp[target][idx] = take + skip;
    }
}
