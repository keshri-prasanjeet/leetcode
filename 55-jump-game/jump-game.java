class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        for(int i=target-1;i>=0;i--){
            if(target - i <= nums[i]){
                target = i;
            }
        }
        if(target == 0) return true;
        return false;
    }
}