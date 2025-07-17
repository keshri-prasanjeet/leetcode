class Solution {
    Integer[] minCoinsMap;
    public int coinChange(int[] coins, int amount) {
        minCoinsMap = new Integer[amount+1];
        int ans = helper(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int amount){
        if(amount == 0) return 0;
        if(minCoinsMap[amount]!=null) return minCoinsMap[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount - coin >= 0){
                int resp = helper(coins, amount-coin);
                if(resp!=Integer.MAX_VALUE){
                    int ans = 1 + helper(coins, amount-coin);
                    minCoins = Math.min(ans, minCoins);
                }
            }
        }
        return minCoinsMap[amount] = minCoins;
    }
}