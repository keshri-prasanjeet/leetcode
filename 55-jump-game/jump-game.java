class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i=last-1;i>=0;i--){
            if(last - i <= nums[i]){
                last = i;
            }
        }
        if(last == 0) return true;
        return false;
    }
}