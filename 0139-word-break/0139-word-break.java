class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++){
            if(dp[i]==true){
                for(String word:wordDict){
                    if((word.length() <= s.length()-i) && s.startsWith(word, i)){
                        dp[i+word.length()] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}