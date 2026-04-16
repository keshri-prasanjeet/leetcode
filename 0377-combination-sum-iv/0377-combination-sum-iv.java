class Solution {
    Integer[] dp = new Integer[1001];
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        if(target <  0) return 0;
        if(dp[target]!=null) return dp[target];
        int totalCombination = 0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int num = nums[i]; 
            totalCombination+=combinationSum4(nums, target-num);
        }

        return dp[target] = totalCombination;
    }
}