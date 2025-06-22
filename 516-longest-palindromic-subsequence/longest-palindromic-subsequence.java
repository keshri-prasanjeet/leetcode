class Solution {
    Integer dp[][];
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        dp = new Integer[len][len];
        return calculateLongest(s, 0, len-1);
    }

    private int calculateLongest(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2 + calculateLongest(s, i+1, j-1);
        }
            
        else{
            return dp[i][j] = Math.max(
                calculateLongest(s, i+1, j),
                calculateLongest(s, i, j-1)
            );
        }
    }
}