class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        dp = new Integer[len1][len2];
        return findDistinct(s, t, len1-1, len2-1);
    }

    private int findDistinct(String s, String t, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = findDistinct(s, t, i-1, j-1) + findDistinct(s, t, i-1, j);
        }
        else{
            return dp[i][j] = findDistinct(s, t, i-1, j);
        }
    }
}