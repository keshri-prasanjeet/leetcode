class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMin = 0;
        int curMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;
        
        for(int num:nums){
            totalSum += num;

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(curMin, minSum);

            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
        }

        if(minSum==totalSum) return maxSum;
        return Math.max(maxSum, (totalSum - minSum));
    }
}