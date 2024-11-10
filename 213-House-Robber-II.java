class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        return Math.max(houseRobber(0, nums.length-2, nums), houseRobber(1, nums.length-1, nums));
    }

    private int houseRobber(int start, int end, int[] nums){

        int twoBehind = 0;
        int oneBehind = nums[start];
        int current = oneBehind;

        for(int i=start+1;i<=end;i++){
            current = Math.max(oneBehind, nums[i]+twoBehind);
            twoBehind = oneBehind;
            oneBehind = current;
        }

        return current;
    }
}