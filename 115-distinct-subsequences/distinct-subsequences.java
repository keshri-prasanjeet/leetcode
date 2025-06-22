class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        dp = new Integer[ls][lt];
        return subCount(s, t, ls-1, lt-1);
    }

    private int subCount(String s, String t, int i, int j){
        
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!= null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            //have two options, take the match or act like no match
            return dp[i][j] = subCount(s, t, i-1, j-1) + subCount(s, t, i-1, j);
        }
        else return dp[i][j] = subCount(s, t, i-1, j);
    }
}