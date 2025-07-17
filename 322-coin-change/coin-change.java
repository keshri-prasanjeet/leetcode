class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        int minCoins = findMinCoins(coins, amount);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int findMinCoins(int[] coins, int amount){
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[amount]!=null) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = findMinCoins(coins, amount-coin);
            if(res!=Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, res+1);
            }
        }
        return dp[amount] = minCoins;
    }
}