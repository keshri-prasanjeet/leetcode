class Solution {
    public int rob(int[] nums) {
        int[] robTable = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            robTable[i] = -1;
        }

        return doRobbery(nums, robTable, 0);
    }

    private int doRobbery(int[] nums, int[] robTable, int index){
        if(index >= nums.length) return 0;
        if(robTable[index] != -1) return robTable[index];

        int robNext = doRobbery(nums, robTable, index+1);
        int skipNext = nums[index] + doRobbery(nums, robTable, index+2);

        robTable[index] = Math.max(robNext, skipNext);
        return robTable[index];
    }
}