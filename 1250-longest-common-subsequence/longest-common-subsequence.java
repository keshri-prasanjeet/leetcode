class Solution {
    Integer[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new Integer[len1+1][len2+1];
        return findLCS(len1-1, len2-1, text1, text2, 0);
    }

    private int findLCS(int i, int j, String text1, String text2, int matched){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
           return dp[i][j] = 1 + findLCS(i-1, j-1, text1, text2, matched+1);
        }
        else{
            return dp[i][j] = Math.max(
                findLCS(i-1, j, text1, text2, matched),
                findLCS(i, j-1, text1, text2, matched)
            );
        }
    }


}