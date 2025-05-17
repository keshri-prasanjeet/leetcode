class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeroCount++;
            if(zeroCount > k){
                if(nums[start++]==0) zeroCount--;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}