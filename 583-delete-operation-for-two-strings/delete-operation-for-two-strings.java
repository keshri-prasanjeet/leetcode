class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int oLen = word1.length();
        int tLen = word2.length();
        dp = new Integer[oLen][tLen];
        return findMinDelete(word1, word2, oLen-1, tLen-1);
    }

    private int findMinDelete(String s, String t, int i, int j){
        if(j<0) return i + 1;
        if(i<0) return j + 1;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = findMinDelete(s, t, i-1, j-1);
        }
        else{
            return dp[i][j] = 1 + Math.min(
                findMinDelete(s, t, i-1, j),
                findMinDelete(s, t, i, j-1)
            );
        }
    }
}