class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //sort the strings and then make the map of them
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        List<List<String>> answerList = new ArrayList<>();

        anagramMap.forEach((key, value) -> {
            answerList.add(value);
        });
        return answerList;
    }
}