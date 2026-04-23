class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length + 1];
        int result = findWinner(stoneValue, 0);
        if(result > 0) return "Alice";
        else if(result < 0) return "Bob";
        else return "Tie";
    }

    private int findWinner(int[] stones, int idx){
        if(idx == stones.length) return 0;
        if(dp[idx]!=null) return dp[idx];
        int diff = Integer.MIN_VALUE;
        int stoneValue = 0;

        for(int i=0;i<3 && idx+i < stones.length;i++){
            stoneValue+=stones[idx+i];
            diff = Math.max(diff, stoneValue - findWinner(stones, idx+i+1));
        }

        return dp[idx] = diff;
    }
}