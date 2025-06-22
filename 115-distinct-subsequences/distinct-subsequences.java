class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        dp = new Integer[sLen][tLen];
        return maxSub(s, t, sLen-1, tLen-1);
    }

    private int maxSub(String s, String t, int i, int j){
        if(j<0) return 1;//we have found the entire t
        if(i<0) return 0;//we have exhausted our s
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = maxSub(s, t, i-1, j-1) + maxSub(s, t, i-1, j);
        }
        else{
            return dp[i][j] = maxSub(s, t, i-1, j);
        }
    }
}