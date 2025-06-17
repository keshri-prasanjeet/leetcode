class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n){
        dp = new int[m+1][n+1];
        return douniquePaths(m,n);
    }

    private int douniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        if(m<=0 || n<=0) return 0;
        if(dp[m][n]!=0) return dp[m][n];
        int countWays = 0;
        countWays += douniquePaths(m-1, n);
        countWays += douniquePaths(m, n-1);
        dp[m][n] = countWays;
        return countWays;
    }
}