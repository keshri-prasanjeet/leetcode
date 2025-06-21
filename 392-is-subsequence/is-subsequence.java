class Solution {
    Boolean[][] dp;
    public boolean isSubsequence(String s, String t) {
        int l = s.length();
        int l2= t.length();
        dp = new Boolean[l][l2];
        return isSubsequence(l-1, l2-1, s, t);
    }

    private boolean isSubsequence(int i, int j, String s, String t){
        if(i<0 ) return true;
        if(j<0) return false;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = isSubsequence(i-1, j-1, s, t);
        return dp[i][j] = isSubsequence(i, j-1, s, t);
    }
}