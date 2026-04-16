class Solution {
public:
    int helper(vector<int>&nums, int target, vector<int>&dp)
    {
        if(target==0)
            return 1;
        if(dp[target]!=-1) return dp[target];
        dp[target]=0;
        for(auto&ell:nums)
        {
            if(ell<=target) dp[target]+=helper(nums,target-ell,dp);
        }
        return dp[target];
    }
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target+1, -1);
        return helper(nums, target, dp);
    }
};