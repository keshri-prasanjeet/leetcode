class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        //break it into subproblem
        //we got two choices go right or go down
        //if our current cell is match we add 1 + Max(right, down) and return
        dp = new int[text1.length()+1][text2.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLCS(text1, text2, 0, 0);
    }

    private int findLCS(String text1, String text2, int i, int j){
        if(i == text1.length() || j == text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCommon = 0;
        if(text1.charAt(i) == text2.charAt(j)) maxCommon = 1 + findLCS(text1, text2, i+1, j+1);
        else maxCommon = Math.max(findLCS(text1, text2, i+1, j), findLCS(text1, text2, i, j+1));

        return dp[i][j] = maxCommon;
    }
}