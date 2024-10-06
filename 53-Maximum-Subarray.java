class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int curSum = nums[0];
        int gloSum = nums[0];
        for(int i=1;i<nums.length;i++){
            curSum = curSum < 0 ? nums[i] : curSum + nums[i];
            gloSum = Math.max(curSum, gloSum);
        }
        return gloSum;
    }
}