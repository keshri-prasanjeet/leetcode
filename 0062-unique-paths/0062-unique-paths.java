class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        // only way to reach the goal is to move either right or bottom
        // at each grid we have two options, go down or go right
        // never go out of bounds
        // return total number of possible paths that can one take
        dp = new Integer[m+1][n+1];
        return findUniquePaths(m, n);
    }

    private int findUniquePaths(int m, int n){
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 || n == 1) return 1;
        if(dp[m][n]!=null) return dp[m][n];
        return dp[m][n] = findUniquePaths(m-1, n) + findUniquePaths(m, n-1);
    }
}