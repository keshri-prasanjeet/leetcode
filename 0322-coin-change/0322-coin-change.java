class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        int ans = makeTargetSum(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int makeTargetSum(int[] coins, int amount){
        if(amount == 0) return 0;
        if(dp[amount]!=null) return dp[amount];
        int fewestCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount - coin >= 0){
                int coinsUsed = makeTargetSum(coins, amount-coin);
                if(coinsUsed != Integer.MAX_VALUE){
                    fewestCoins = Math.min(fewestCoins, 1 + coinsUsed);
                }
            }
        }
        return dp[amount] = fewestCoins;
    }
}