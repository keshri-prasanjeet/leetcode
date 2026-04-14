class Solution {
    Integer[] dp1;
    Integer[] dp2;
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        dp1 = new Integer[len];
        dp2 = new Integer[len];
        return Math.max(robHouses(nums, 0, len-2, dp1), robHouses(nums, 1, len-1, dp2));
    }

    private int robHouses(int[] nums, int idx, int end, Integer[] dp){
        if(idx > end) return 0;
        if(dp[idx]!=null) return dp[idx];

        int robCur = nums[idx] + robHouses(nums, idx+2, end, dp);
        int skpCur = robHouses(nums, idx+1, end, dp);

        return dp[idx] = Math.max(robCur, skpCur);
    }
}