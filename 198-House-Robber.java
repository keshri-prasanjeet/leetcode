class Solution {
    int[] robMap;
    public int rob(int[] nums) {
        this.robMap = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            robMap[i] = -1;
        }
        return doRobbery(nums, 0);
    }

    private int doRobbery(int[] nums, int index){
        if(index >= nums.length) return 0;
        if(robMap[index]!=-1) return robMap[index];

        int robNext = doRobbery(nums, index+1);
        int skipNext = nums[index] + doRobbery(nums, index+2);

        robMap[index] = Math.max(robNext, skipNext);
        return robMap[index];
    }
}