class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        dp = new Integer[len1+1][len2+1];
        findLCS(text1, text2, 0, 0);
        return dp[0][0];
    }

    private int findLCS(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>=text2.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + findLCS(text1, text2, i+1, j+1);
        }
        else dp[i][j] = Math.max(findLCS(text1, text2, i+1, j), findLCS(text1, text2, i, j+1));

        return dp[i][j];
    }
}