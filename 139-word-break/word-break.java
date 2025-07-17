class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i = s.length(); i>=0 ;i--){
            for(String word: wordDict){
                int len = word.length();
                if(len + i <=s.length()){
                    if(word.equals(s.substring(i,i+len))){
                        dp[i] = dp[i+len];
                    }
                }
                if(dp[i]==true) break;
            }
        }
        return dp[0];
    }
}