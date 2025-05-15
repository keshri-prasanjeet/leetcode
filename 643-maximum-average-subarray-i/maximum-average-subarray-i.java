class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // create a window 
        // find the sum & average and store
        // move the window

        int i=0;
        int sum = 0;
        while(i<k){
            sum+=nums[i++];
        }
        int left = 0;
        int right = k-1;
        double avg = -999999999.0;
        while(right<nums.length){
            avg = Math.max(avg, ((double)sum / (double) k));
            sum-=nums[left++];
            if(right == nums.length-1) break;
            sum+=nums[++right];
        }
        return avg;
    }
}