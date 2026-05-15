class Solution {
    int globalM;
    int globalN;
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        //return the number of unique paths the robot can take
        //if the robot is at column above or row left of target it can only take one step
        globalM = m;
        globalN = n;
        dp = new Integer[m+1][n+1];
        return findUniquePaths(0,0);
    }

    private int findUniquePaths(int i, int j){
        if(i==globalM-1) return 1;
        if(j==globalN-1) return 1;
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j] = findUniquePaths(i+1,j) + findUniquePaths(i, j+1);
    }
}