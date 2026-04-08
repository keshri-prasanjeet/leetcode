class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m+1][n+1];
        return findUnique(m,n);
    }

    private int findUnique(int m, int n){
        if(m<=0 && n<=0) return 0;
        if(m==1 || n==1) return 1;

        if(dp[m][n]!=null) return dp[m][n];

        int ways = 0;
        ways += findUnique(m-1, n);
        ways += findUnique(m, n-1);
        return dp[m][n] = ways;
    }
}