class Solution {
    List<String> answer;
    Map<Integer, List<String>> wordsMap=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        answer = new ArrayList<>();
        return findSentences(s, wordDict, 0);
    }

    private List<String> findSentences(String s, List<String> wordDict, int index){
        if(wordsMap.containsKey(index)) return wordsMap.get(index);
        List<String> result = new ArrayList<>();
        if(index == s.length()){
            result.add("");
            return result;
        }

        for(String word: wordDict){
            int len = word.length();
            if(index + len > s.length()) continue;
            if(s.startsWith(word, index)){
                List<String> suffix = findSentences(s, wordDict, index+len);
                for(String sub: suffix){
                    if(sub.isEmpty()){
                        result.add(word);
                    }
                    else{
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        wordsMap.put(index, result);
        return result;
    }
}