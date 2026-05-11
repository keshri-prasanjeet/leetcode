class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        //the coins available to me
        //total money = amount
        //return number of combinations to make that amount
        //if amount of money cannot be made ever then return 0

        //at each step i have two choices, take or skip
        //if i am able to make the target as 0 then the amount has been made
        // and i can return 1
        dp = new Integer[amount+1][coins.length+1];
        return doCoinChange(amount, coins, 0);
    }

    private int doCoinChange(int amount, int[] coins, int index){
        if(amount ==0) return 1;
        if(amount < 0) return 0;
        if(dp[amount][index]!=null) return dp[amount][index];
        if(index >= coins.length) return 0;

        //two choices

        int take = doCoinChange(amount - coins[index], coins, index);
        int skip = doCoinChange(amount, coins, index+1);
        
        return dp[amount][index] = take+skip;
    }
}