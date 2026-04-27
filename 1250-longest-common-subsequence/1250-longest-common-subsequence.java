class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new int[len1][len2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return findLCS(text1, text2, len1-1, len2-1);
    }

    private int findLCS(String text1, String text2, int i, int j){
        if(i<0 || j<0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + findLCS(text1, text2, i-1, j-1);
        }
        else dp[i][j] = Math.max(findLCS(text1, text2, i-1, j), findLCS(text1, text2, i, j-1));

        return dp[i][j];
    }
}