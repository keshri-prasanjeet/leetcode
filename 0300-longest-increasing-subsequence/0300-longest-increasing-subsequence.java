class Solution {
    public int lengthOfLIS(int[] nums) {
        //longest increasing subsequence
        int[] longestIncrS = new int[nums.length];
        int ans = 0;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    longestIncrS[i] = Math.max(longestIncrS[i], longestIncrS[j]+1);
                }
            }
            ans = Math.max(ans, longestIncrS[i]);
        }
        return ans+1;
    }
}