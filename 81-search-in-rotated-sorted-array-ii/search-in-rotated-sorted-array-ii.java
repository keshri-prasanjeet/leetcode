class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return true;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                //cant decide which part is sorted so just shrink
                left++;
                right--;
            }
            else if(nums[mid] <= nums[right]){
                //right part is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }
                else right = mid-1;
            }
            else{
                //left part is sorted
                if(nums[mid] > target && target >= nums[left]){
                    right = mid-1;
                }
                else left = mid+1;
            }
        }
        return false;
    }
}