class Solution {
    Integer[][] dp;
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp = new Integer[m+1][n+1];
                max = Math.max(max,findLIP(matrix, i, j, -1));
            }
        }
        return max;
    }
    private int findLIP(int[][] matrix, int i, int j, int prev){
        if( i < 0 || 
            i == matrix.length || 
            j < 0 ||
            j == matrix[0].length ||
            matrix[i][j] <= prev){
                return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int max = 0;
        for(int[] dir: directions){
            max = Math.max(max, findLIP(matrix, i+dir[0], j+dir[1], matrix[i][j]));
        }

        return dp[i][j] = max+1;
    }
}