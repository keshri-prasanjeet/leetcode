class Solution {
    public boolean canPartition(int[] nums) {
        //to partition it in two equal parts, the sum must be even
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        Arrays.sort(nums);
        boolean[] targetSum = new boolean[(sum/2)+1];
        targetSum[0] = true;
        for(int num:nums){
            for(int i=sum/2;i>=num;i--){
                targetSum[i] = targetSum[i] || targetSum[i-num];
            }
        }
        return targetSum[sum/2];
    }
}