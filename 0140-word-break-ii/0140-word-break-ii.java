class Solution {
    Map<Integer, List<String>> wordsMap = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        return findSentences(s, wordDict, 0);
    }

    private List<String> findSentences(String s, List<String> words, int idx){
        if(wordsMap.containsKey(idx)) return wordsMap.get(idx);
        List<String> result = new ArrayList<>();
        if(idx == s.length()){
            result.add("");
            return result;
        }
        for(String word:words){
            int wordLen = word.length();
            if(wordLen + idx > s.length()) continue;
            if(s.startsWith(word, idx)){
                List<String> subResult = findSentences(s, words, idx+wordLen);
                for(String sub:subResult){
                    if(sub.isEmpty()){
                        result.add(word);
                    }
                    else {
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        wordsMap.put(idx, result);
        return result;
    }
}