class Solution {
    Integer[][][] dp;
    public int stoneGameII(int[] piles) {
        //maximum number of stones alice can get
        //alice winning(maximising)
        //bob trying to win(minimising alice score)
        int len = piles.length;
        dp = new Integer[len+1][len+1][2];
        return maxAliceStones(piles, 0, 1, 1);
    }


    private int maxAliceStones(int[] piles, int index, int turn, int m){
        if(index >=piles.length) return 0;
        if(dp[index][m][turn]!=null) return dp[index][m][turn];
        int res = turn == 1 ? 0 : Integer.MAX_VALUE;
        int stonesTaken = 0;
        for(int x=1;x<=2*m;x++){
            if(index+x-1 >= piles.length) break;
            if(turn == 1){
                stonesTaken+=piles[index+x-1];
                res = Math.max(res, stonesTaken+maxAliceStones(piles, index+x, 0, Math.max(x,m)));
            }
            else{
                res = Math.min(res, maxAliceStones(piles, index+x, 1, Math.max(x,m)));
            }
        }
        return dp[index][m][turn] = res;
    }
}