class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(prefixSumMap.containsKey(sum - k)){
                count += prefixSumMap.get(sum-k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum , 0) +1);
        }

        return count;
    }
}