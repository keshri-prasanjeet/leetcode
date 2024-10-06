class Solution {
    int answerIndex;
    public int searchInsert(int[] nums, int target) {
        this.answerIndex = -1;
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        if(target == nums[nums.length-1]) return nums.length-1;
        doBinarySearch(0, nums.length-1,nums,target);
        return answerIndex;
    }

    private void doBinarySearch(int start, int end, int[] nums, int target){
        if(start >= end) return;
        
        int mid = start + (end-start)/2;
        if(nums[mid] > target){
            answerIndex = mid;
            doBinarySearch(start, mid, nums, target);
        }
        else if(nums[mid] < target){
            answerIndex = mid+1;
            doBinarySearch(mid+1, end, nums, target);
        }
        else{
            answerIndex = mid;
            return;
        }
    }
}