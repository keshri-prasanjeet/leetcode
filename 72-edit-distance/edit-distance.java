class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        dp = new Integer[len1+1][len2+1];
        return calculateMinDistance(len1, len2, word1, word2);
    }

    private int calculateMinDistance(int index1, int index2, String word1, String word2){
        if(index1 == 0) return index2;
        if(index2 == 0) return index1;

        if(dp[index1][index2]!=null) return dp[index1][index2];

        if(word1.charAt(index1-1) == word2.charAt(index2-1)) 
            return dp[index1][index2] = calculateMinDistance(index1-1, index2-1, word1, word2);
        else{
            int insert = calculateMinDistance(index1, index2-1, word1, word2);
            int delete = calculateMinDistance(index1-1, index2, word1, word2);
            int replace= calculateMinDistance(index1-1,index2-1,word1, word2);
            return dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }
}