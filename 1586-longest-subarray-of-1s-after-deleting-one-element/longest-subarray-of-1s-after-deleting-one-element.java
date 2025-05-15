class Solution {
    public int longestSubarray(int[] nums) {
        //see a zero, "delete" it
        //continue until you see zero again
        //shrink the window until that deleted zero
        //delete this new zero and expand the window as much as you can
        //rinse repeat

        boolean deleted = false;
        int len = nums.length;
        int start = 0;
        int longestSubArr = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                if(deleted != true){
                    deleted = true;
                }
                else{
                    while(deleted == true){
                        if(nums[start++] == 0) deleted = false;
                    }
                    deleted = true;
                }
            }

            longestSubArr = Math.max(longestSubArr, i-start);

        }
        return longestSubArr;
    }
}