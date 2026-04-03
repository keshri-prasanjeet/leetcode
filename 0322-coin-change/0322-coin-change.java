class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        int[] scoins = Arrays.stream(coins)
                         .boxed()
                         .sorted(Collections.reverseOrder())
                         .mapToInt(Integer::intValue)
                         .toArray();
        int fewest = fewestCoinsChange(scoins, amount);
        return fewest == Integer.MAX_VALUE ? -1 : fewest;
    }

    private int fewestCoinsChange(int[] coins, int amount){
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[amount]!=null) return dp[amount];
        int fewestCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount - coin >= 0){
                int coinsUsed = fewestCoinsChange(coins, amount-coin);
                if(coinsUsed != Integer.MAX_VALUE){
                    fewestCoins = Math.min(fewestCoins, 1 + coinsUsed);
                }
            }
        }
        dp[amount] = fewestCoins;
        return dp[amount];
    }
}