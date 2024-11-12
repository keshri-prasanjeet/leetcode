class Solution {
    //version for better memory
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(robWithLimits(0, nums.length-2, nums), robWithLimits(1, nums.length-1, nums));
    }

    private int robWithLimits(int startIndex, int endIndex, int[] houseMoney){
        int twoHouseBehind = 0;
        int oneHouseBehind = houseMoney[startIndex];
        int currentBestRobbery = oneHouseBehind;
        for(int i=startIndex+1; i<=endIndex; i++){
            currentBestRobbery = Math.max(oneHouseBehind, houseMoney[i] + twoHouseBehind);
            twoHouseBehind = oneHouseBehind;
            oneHouseBehind = currentBestRobbery;
        }
        return currentBestRobbery;
    }
}