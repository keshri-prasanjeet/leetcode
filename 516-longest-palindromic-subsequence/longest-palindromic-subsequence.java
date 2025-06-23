class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        dp = new Integer[len][len];
        return lps(s, 0, len-1);
    }

    private int lps(String s, int i, int j){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2 + lps(s, i+1, j-1);
        }
        else{
            return dp[i][j] = Math.max(
                lps(s, i+1, j),
                lps(s, i, j-1)
            );
        }
    }
}