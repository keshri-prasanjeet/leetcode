class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1;i>=0;i--){
            for(String word:wordDict){
                if(i+word.length() <= s.length() && word.equals(s.substring(i,i+word.length()))){
                    dp[i] = dp[i+word.length()];
                    if(dp[i]==true) break;
                }
            }
        }

        return dp[0];
    }
}