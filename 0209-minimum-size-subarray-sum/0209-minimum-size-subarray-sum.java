class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int minLength = len+1;
        int sum = 0;
        while(right<len){
            sum+=nums[right];
            while(sum >= target){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength != len+1 ? minLength : 0;
    }
}