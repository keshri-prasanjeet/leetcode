class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] LIS = new int[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    LIS[i] = Math.max(LIS[j]+1, LIS[i]);
                }
            }
            maxLen = Math.max(maxLen, LIS[i]);
        }
        return maxLen+1;
    }
}