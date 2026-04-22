class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length + 1];
        int res = findWinner(stoneValue, 0);
        if(res > 0) return "Alice";
        else if (res < 0) return "Bob";
        else return "Tie";
    }

    private int findWinner(int[] stones, int index){
        if(index >= stones.length) return 0;
        if(dp[index]!=null) return dp[index];
        int diff = Integer.MIN_VALUE;
        int stonesValue = 0;
        for(int i=0;i<3 && i+index < stones.length;i++){
            stonesValue+=stones[index+i];
            diff = Math.max(diff, stonesValue - findWinner(stones, index+i+1));
        }
        return dp[index] = diff;
    }
}