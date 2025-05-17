class Solution {
    public int longestSubarray(int[] nums) {
        boolean deleted = false;
        int start = 0;
        int subLen = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                if(deleted == false){
                    deleted = true;
                }
                else{
                    while(nums[start]==1){
                        start++;
                    }
                    start++;
                }
            }
            subLen = Math.max(subLen, i-start);
        }
        return subLen;
    }
}