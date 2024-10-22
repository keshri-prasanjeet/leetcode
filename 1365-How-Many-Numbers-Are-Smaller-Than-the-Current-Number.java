class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = nums.clone();
        Map<Integer,Integer> numsMap = new HashMap<>();
        Arrays.sort(sortedNums);
        for(int i=sortedNums.length-1;i>=0;i--){
            numsMap.put(sortedNums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = numsMap.get(nums[i]);
        }
        return nums;
    }
}