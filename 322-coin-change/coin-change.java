class Solution {
    Integer dp[];
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        int res = helper(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int helper(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(dp[amount]!=null) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            int result = helper(coins, amount - coin);
            if(result != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, result+1);
            }
        }
        return dp[amount] = minCoins;
    }
}