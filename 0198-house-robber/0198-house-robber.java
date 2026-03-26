class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        memo = new Integer[nums.length+1];
        return Math.max(doRob(nums, 0), doRob(nums, 1));
    }

    private int doRob(int[] nums, int index){
        if(index >= nums.length) return 0;
        if(memo[index]!=null) return memo[index];
        memo[index] = Math.max((doRob(nums, index+2) + nums[index]), (doRob(nums, index+1)));
        return memo[index];
    }
}