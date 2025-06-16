class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] robTable = new int[len+1];
        if(len==1) return nums[0];
        if(len==2) return nums[0] > nums[1] ? nums[0] : nums[1];

        robTable[0] = nums[0];
        robTable[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for(int i=2;i<len;i++){
            robTable[i] = Math.max(robTable[i-1], (robTable[i-2]+nums[i]));
        }
        return Math.max(robTable[len-1], robTable[len-2]);
    }
}