class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int len1= word1.length();
        int len2= word2.length();
        dp = new Integer[len1+1][len2+1];
        return calculateMinDistance(len1, len2, word1, word2);
    }

    private int calculateMinDistance(int i, int j, String w1, String w2){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=null) return dp[i][j];
        if(w1.charAt(i-1) == w2.charAt(j-1)) return dp[i][j] = calculateMinDistance(i-1, j-1, w1, w2);

        else{
            int insert = calculateMinDistance(i, j-1, w1, w2);
            int delete = calculateMinDistance(i-1, j, w1, w2);
            int replace= calculateMinDistance(i-1,j-1, w1,w2);
            return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }
}