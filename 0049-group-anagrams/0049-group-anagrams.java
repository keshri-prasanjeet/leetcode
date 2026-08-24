class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            groups.computeIfAbsent(sortedStr, sStr -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}