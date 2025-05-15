class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int zeroCount = 0;
        int start = 0;
        int maxLen = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[start++] == 0) zeroCount--;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}