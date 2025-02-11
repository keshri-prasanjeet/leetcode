class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // i can make a map of string list<String>
        // the key will be the sorted string
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String word: strs){
            String sortedWord = stringSort(word);
            if(groupMap.containsKey(sortedWord)){
                groupMap.get(sortedWord).add(word);
            }
            else{
                List<String> valueList = new ArrayList<>();
                valueList.add(word);
                groupMap.put(sortedWord, valueList);
            }
        }
        List<List<String>> answer = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: groupMap.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }

    private String stringSort(String word){
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);
    }
}