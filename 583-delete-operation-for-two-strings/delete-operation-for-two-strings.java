class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        dp = new Integer[len1][len2];
        return calculateDistance(word1, word2, len1-1, len2-1);
    }

    private int calculateDistance(String word1, String word2, int i, int j){
        //base case if we reach the end of a string then the entirety of the other sting has to be deleted
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=null) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = calculateDistance(word1, word2, i-1, j-1);
        }
        else{
            return dp[i][j] = 1 + Math.min(
                calculateDistance(word1, word2, i-1, j),
                calculateDistance(word1, word2, i, j-1)
            );
        }
    }
}