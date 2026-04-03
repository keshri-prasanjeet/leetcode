class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        int[] sortedDesc = Arrays.stream(coins)
                         .boxed()
                         .sorted(Collections.reverseOrder())
                         .mapToInt(Integer::intValue)
                         .toArray();
        int fewest = fewestCoinsChange(sortedDesc, amount, 0);
        return fewest == Integer.MAX_VALUE ? -1 : fewest;
    }

    private int fewestCoinsChange(int[] coins, int amount, int coin){
        // if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0){
            return coin;
        }
        if(dp[amount]!=null) return dp[amount];
        int fewestCoins = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount){
                fewestCoins = Math.min(fewestCoins, fewestCoinsChange(coins, amount - coins[i], coin+1));
            }
            
        }
        dp[amount] = fewestCoins;
        return dp[amount];
    }
}