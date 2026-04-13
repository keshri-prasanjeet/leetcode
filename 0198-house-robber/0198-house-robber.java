class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return Math.max(robHouse(nums, 0), robHouse(nums, 1));
    }
    private int robHouse(int[] nums, int index){
        if(index >= nums.length) return 0;
        if(dp[index]!=null) return dp[index];
        int robCur = nums[index] + robHouse(nums, index+2);
        int skipCur = robHouse(nums, index+1);
        return dp[index] = Math.max(robCur, skipCur);
    }
}