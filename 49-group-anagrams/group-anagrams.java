class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String str: strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
            if(anagramMap.containsKey(sortedStr)){
                anagramMap.get(sortedStr).add(str);
            }
            else{
                anagramMap.put(sortedStr, new ArrayList<>(List.of(str)));
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: anagramMap.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
}