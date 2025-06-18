class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n){
        dp = new int[m+1][n+1];
        return doUniquePaths(m,n);
    }
    public int doUniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        if(m<=0 || n<=0) return 0;

        if(dp[m][n]!=0) return dp[m][n];

        int ways = 0;
        ways += doUniquePaths(m-1, n);
        ways += doUniquePaths(m, n-1);
        dp[m][n] = ways;
        return ways;
    }
}