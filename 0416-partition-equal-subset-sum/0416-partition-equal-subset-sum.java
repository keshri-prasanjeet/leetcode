class Solution {
    boolean equalSubset = false;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0) return false;
        int halfVal = totalSum / 2;
        Arrays.sort(nums);
        findPartition(nums, halfVal, 0, 0);
        return equalSubset;
    }

    private void findPartition(int[] nums, int halfVal, int idx, int sum){
        if(equalSubset == true) return;
        if(idx>=nums.length) return;
        if(sum == halfVal){
            equalSubset = true;
            return;
        }
        
        //take 
        findPartition(nums, halfVal, idx+1, sum+nums[idx]);
        //don't take
        findPartition(nums, halfVal, idx+1, sum);
    }
}