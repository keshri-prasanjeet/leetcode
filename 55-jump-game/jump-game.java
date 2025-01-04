class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len-1;
        for(int i=len-2;i>=0;i--){
            int cur = i;
            if((last - cur) <= nums[cur]){
                last = cur;
            }
        }
        if(last == 0) return true;
        return false;
    }
}