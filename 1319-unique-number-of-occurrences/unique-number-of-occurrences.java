class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Set<Integer> countSet = new HashSet<>();
        for(int n:arr){
            numMap.put(n, numMap.getOrDefault(n,0)+1);
        }
        for(Integer val: numMap.values()){
            if(!countSet.contains(val)) countSet.add(val);
            else return false;
        }
        return true;
    }
}