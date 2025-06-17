class Solution {
    int[][] dp = new int[1001][1001];
    long mod = 1000000007;
    public int numTilings(int n) {
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                dp[i][j] = -1;
            }
        }
        return countTilingWays(n,n);
    }

    private int countTilingWays(int r1, int r2){
        if(r1==0 && r2 ==0) return 1;
        if(r1<=0 || r2 <=0) return 0;
        if(dp[r1][r2] != -1) return dp[r1][r2];

        //now we will start recursive calls
        long count = 0;
        if(r1==r2){
            count += countTilingWays(r1-2, r2-2);
            count += countTilingWays(r1-1, r2-1);
            count += countTilingWays(r1-2, r2-1);
            count += countTilingWays(r1-1, r2-2); 
        }
        else if(r1<r2){
            count += countTilingWays(r1-1, r2-2);
            count += countTilingWays(r1, r2-2);
        }
        else{
            count += countTilingWays(r1-2, r2-1);
            count += countTilingWays(r1-2, r2);
        }
        count %= mod;
        return dp[r1][r2] = (int)count;
    }
}