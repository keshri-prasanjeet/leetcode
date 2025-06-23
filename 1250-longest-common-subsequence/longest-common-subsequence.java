class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new Integer[len1][len2];
        return lcs(text1, text2, len1-1, len2-1);
    }

    private int lcs(String s, String t, int i, int j){
        if(i<0) return 0;
        if(j<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = 1 + lcs(s,t, i-1, j-1);
        }
        else{
            return dp[i][j] = Math.max(
                lcs(s, t, i-1, j),
                lcs(s, t, i, j-1)
            );
        }
    }
}