class Solution {
    //solution dp with memoization
    Boolean[] charMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        charMap = new Boolean[s.length()+1];
        return findWord(s, wordDict, 0);
    }

    private boolean findWord(String s, List<String> words, int startIdx){
        if(startIdx == s.length()) return true;
        if(charMap[startIdx]!=null) return charMap[startIdx];
        
        for(String word: words){
            int len=word.length();
            if(startIdx + len > s.length()) continue;
            if(s.substring(startIdx, startIdx+len).equals(word)){
                if(findWord(s, words, startIdx+len)) {
                    return charMap[startIdx] = true;
                }
            }
        }
        return charMap[startIdx] = false;
    }
}