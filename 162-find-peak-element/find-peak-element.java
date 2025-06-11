class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right= len-1;

        while(left >=0 && right < len && left<=right){
            int mid = left+(right-left)/2;
            int leftS = mid-1<0 ? Integer.MIN_VALUE : nums[mid-1];
            int rightS = mid+1>=len ? Integer.MIN_VALUE : nums[mid+1];
            int midVal = nums[mid];
            if(leftS < midVal && midVal > rightS) return mid;
            else if(midVal < rightS) left = mid+1;
            else right = mid-1;
        }
        return 0;
    }
}