class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=0;i<len;i++){
            if(dp[i] == true){
                for(String word:wordDict){
                    int wordLen = word.length();
                    if(i+wordLen <= len && s.startsWith(word, i)){
                        dp[i+wordLen] = true;
                    }
                }
            }
        }
        return dp[len];
    }
}