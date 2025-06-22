class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        dp = new Integer[len1][len2];
        return calculateOperations(word1, word2, len1-1, len2-1);
    }

    private int calculateOperations(String s, String t, int i, int j){
        if(i<0) return j+1; //we have exhausted the s, so insert all of j
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = calculateOperations(s, t, i-1, j-1);
        }
        else{
            int update = calculateOperations(s, t, i-1, j-1);
            int delete = calculateOperations(s, t, i-1, j);
            int insert = calculateOperations(s, t, i, j-1);
            return dp[i][j] = 1 + Math.min(update, Math.min(delete, insert));
        }
    }
}