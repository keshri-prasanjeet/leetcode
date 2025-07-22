class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int oneCount = 0;
        int maxLen = 0;
        while(r < nums.length){
            if(nums[r] == 1) oneCount++;
            if(r-l+1 > oneCount + k){
                if(nums[l]==1) oneCount--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}