class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        prefixSumMap.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            sum += num == 0 ? -1 : 1;
            // System.out.println(sum);
            if(prefixSumMap.containsKey(sum)){
                System.out.println(sum);
                maxLen = Math.max(maxLen, i- prefixSumMap.get(sum));
            }
            else prefixSumMap.put(sum, i);
        }
        return maxLen;
    }
}