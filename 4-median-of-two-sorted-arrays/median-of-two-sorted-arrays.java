class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len2 < len1) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = len1;
        while(low <= high){
            int splitOne = (high+low)/2;
            int splitTwo = (len1 + len2 + 1)/2 - splitOne;

            //i have found both the split points and now i need to compare the min and max of both

            int maxOfLeftOfFirst  = splitOne == 0 ? Integer.MIN_VALUE : nums1[splitOne-1];
            int minOfRightOfFirst = splitOne == len1 ? Integer.MAX_VALUE : nums1[splitOne];

            int maxOfLeftOfSecond  = splitTwo == 0 ? Integer.MIN_VALUE : nums2[splitTwo-1];
            int minOfRightOfSecond = splitTwo == len2 ? Integer.MAX_VALUE : nums2[splitTwo];

            //now i have the numbers on edges of both the halves of both the arrays

            if(maxOfLeftOfFirst <= minOfRightOfSecond && maxOfLeftOfSecond <= minOfRightOfFirst){
                //found a valid split to find the median

                if((len1 + len2) % 2 == 0){
                    return (Math.max(maxOfLeftOfFirst, maxOfLeftOfSecond) + Math.min(minOfRightOfFirst, minOfRightOfSecond)) / 2.0;
                }
                else return (double)Math.max(maxOfLeftOfFirst, maxOfLeftOfSecond);
            }
            else if(maxOfLeftOfFirst > minOfRightOfSecond){
                //partition is too far right, too big
                high = splitOne-1;
            }
            else low = splitOne+1;
        }

        return 0.0;
    }
}