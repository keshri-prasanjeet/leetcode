class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num: nums){
            sum+=num;
            count += prefixSumMap.getOrDefault(sum - k, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}