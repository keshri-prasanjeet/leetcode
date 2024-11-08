class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String cur = strs[i];
            String sortedCur = stringSorter(cur);

            if(anagramMap.containsKey(sortedCur)){
                List<String> anagrams = anagramMap.get(sortedCur);
                anagrams.add(cur);
                anagramMap.put(sortedCur, anagrams);
            }
            else{
                List<String> newAnagramList = new ArrayList<>();
                newAnagramList.add(cur);
                anagramMap.put(sortedCur, newAnagramList);
            }
        }
        List<List<String>> groupAnagrams = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: anagramMap.entrySet()){
            groupAnagrams.add(entry.getValue());
        }
        return groupAnagrams;
    }

    String stringSorter(String cur){
        char[] chars = cur.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}