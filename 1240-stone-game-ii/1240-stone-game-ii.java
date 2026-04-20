class Solution {
    Integer[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n+1][2];
        return maxStonesAlice(piles, 1, 0, 0);
    }

    private int maxStonesAlice(int[] piles, int m, int idx, int aliceTurn){
        if(idx >= piles.length) return 0;
        if(dp[idx][m][aliceTurn]!=null) return dp[idx][m][aliceTurn];
        int res = aliceTurn == 0 ? 0 : Integer.MAX_VALUE;
        int totalStones = 0;
        for(int x=1;x<=m*2;x++){
            if(idx + x -1 >= piles.length) break;
            totalStones += piles[idx + x -1];

            if(aliceTurn==0){
                res = Math.max(
                    res, 
                    totalStones + maxStonesAlice(piles, Math.max(x,m), idx+x, 1)
                );
            }
            else{
                res = Math.min(
                    res,
                    maxStonesAlice(piles, Math.max(x,m), idx+x, 0)
                );
            }
        }
        return dp[idx][m][aliceTurn] = res;
    }
}