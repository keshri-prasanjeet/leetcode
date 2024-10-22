class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            if(numsMap.containsKey(compliment) && numsMap.get(compliment)!=i){
                return new int[] {i, numsMap.get(compliment)};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}