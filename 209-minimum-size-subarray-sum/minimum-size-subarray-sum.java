class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSubLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int curSum = 0;
        for(right = 0;right < nums.length; right++){
            curSum+=nums[right];
            while(curSum >= target){
                minSubLen = Math.min(minSubLen, right -left +1);
                curSum-=nums[left++];
            }
        }
        return minSubLen == Integer.MAX_VALUE ? 0 : minSubLen;
    }
}