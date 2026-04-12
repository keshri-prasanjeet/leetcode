class Solution {
    public int maxProduct(int[] nums) {
        int cMax = 1;
        int cMin = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp = nums[i] * cMax;
            cMax = Math.max(nums[i] * cMax, Math.max(nums[i], cMin*nums[i]));
            cMin = Math.min(temp, Math.min(nums[i], cMin*nums[i]));
            ans = Math.max(ans, Math.max(cMin, cMax));
        }
        return ans;
    }
}