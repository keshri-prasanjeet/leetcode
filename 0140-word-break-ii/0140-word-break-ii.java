class Solution {
    Map<Integer,List<String>> wordsMap = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return findSentences(s, wordDict, 0);
    }

    private List<String> findSentences(String s, List<String> words, int idx){
        if(wordsMap.containsKey(idx)) return wordsMap.get(idx);
        List<String> answer = new ArrayList<>();
        if(idx == s.length()){
            answer.add("");
            return answer;
        }
        for(String word: words){
            int wordLen = word.length();
            if(idx + wordLen > s.length()) continue;
            if(s.startsWith(word, idx)){
                List<String> subAnswer = findSentences(s, words, idx+wordLen);
                for(String sub:subAnswer){
                    if(sub.isEmpty()){
                        answer.add(word);
                    }
                    else{
                        answer.add(word + " " + sub);
                    }
                }
            }
        }
        wordsMap.put(idx, answer);
        return answer;
    }
}