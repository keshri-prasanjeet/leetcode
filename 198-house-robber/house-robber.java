class Solution {
    Integer[] robMap;
    public int rob(int[] nums) {
        //at each point of time i have two options skip this or rob this
        robMap = new Integer[nums.length];
        return doRobbery(nums, 0);
    }

    private int doRobbery(int[] nums, int index){
        if(index >= nums.length) return 0;
        if(robMap[index] != null) return robMap[index];
        int skipThis = 0;
        int robThis = 0;

        skipThis = doRobbery(nums, index+1);
        robThis = nums[index] + doRobbery(nums, index+2);

        return robMap[index] = Math.max(skipThis, robThis);
    }
}