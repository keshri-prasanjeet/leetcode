class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> robMap = new HashMap<>();
        return robHouse(nums, 0, robMap);
    }

    private int robHouse(int[] nums, int index, Map<Integer, Integer> robMap){
        if(index >= nums.length) return 0;

        if(robMap.containsKey(index)){ 
            return robMap.get(index);
        }

        int skipCurrent = robHouse(nums, index+1, robMap);
        int robCurrent = nums[index] + robHouse(nums, index+2, robMap);

        int maxLoot = Math.max(skipCurrent, robCurrent);
        robMap.put(index, maxLoot);
        return maxLoot;
    }
}