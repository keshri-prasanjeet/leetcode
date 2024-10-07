class Solution {
    int first;
    int last;
    public int[] searchRange(int[] nums, int target) {
        this.first = Integer.MAX_VALUE;
        this.last = Integer.MIN_VALUE;

        searchRange(nums, 0, nums.length-1, target);
        if(first == Integer.MAX_VALUE) return new int[]{-1, -1};
        return new int[]{first, last};
    }

    private void searchRange(int[] nums, int start, int end, int target){
        if(start > end) return;
        int mid = start + (end-start)/2;

        if(nums[mid]==target){
            first = Math.min(first, mid);
            last = Math.max(last, mid);
            searchRange(nums, start, mid-1, target);
            searchRange(nums, mid+1, end, target);
        }
        else if(nums[mid] > target){
            searchRange(nums, start, mid-1, target);
        }
        else{
            searchRange(nums, mid+1, end, target);
        }
        return;
    }
}