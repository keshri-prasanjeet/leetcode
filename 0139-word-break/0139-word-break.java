class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        return findWord(s, wordDict, 0); 
    }

    private boolean findWord(String s, List<String> wordDict, int idx){
        if(idx == s.length()) return true;
        if(idx > s.length()) return false;
        if(dp[idx]!=null) return dp[idx];
        for(String word: wordDict){
            int wordLen = word.length();
            if(idx+wordLen <= s.length()){
                if(s.substring(idx, idx+wordLen).equals(word)){
                    if(findWord(s, wordDict, idx+wordLen) == true) {
                        dp[idx] = true;
                        return true;
                    }
                }
            }
        }
        dp[idx] = false;
        return false;
    }
}