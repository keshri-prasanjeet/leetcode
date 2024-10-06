class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length-1);
    }

    private int maxSubArray(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int mid = start + (end-start)/2;
        int leftMax = maxSubArray(nums, start, mid);
        int rightMax= maxSubArray(nums, mid+1, end);
        int crossMax= maxCrossingSubArray(nums, start, mid, end);
        return Math.max(crossMax, (Math.max(leftMax, rightMax)));
    }

    private int maxCrossingSubArray(int[] nums, int start, int mid, int end){
        int leftSum = Integer.MIN_VALUE;
        int rightSum= Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=mid; i >=start; i--){
            curSum +=nums[i];
            if(leftSum < curSum) leftSum = curSum;
        }
        curSum = 0;
        for(int i=mid+1;i<=end;i++){
            curSum +=nums[i];
            if(rightSum < curSum) rightSum = curSum;
        }
        return leftSum + rightSum;
    }
}