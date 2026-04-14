class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(robLinear(nums, 0, len-2), robLinear(nums, 1, len-1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;
            int cur = Math.max(take, skip);

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}