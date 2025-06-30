class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len2 < len1) return findMedianSortedArrays(nums2, nums1);

        // core of the problem is to find a partition point
        // a partition in nums1 and nums2
        // pick a point in nums1 to partition and generate a point in nums2 from point in nums1

        int low = 0;
        int high = len1;
        double answer = 0.0;        
        while(low <= high){
            int partitionOne = (low + high) / 2;
            int partitionTwo = (len1 + len2 + 1) / 2 - partitionOne;

            int firstMax = partitionOne == 0 ? Integer.MIN_VALUE : nums1[partitionOne-1];
            int firstMin = partitionOne == len1 ? Integer.MAX_VALUE : nums1[partitionOne];

            int secondMax = partitionTwo == 0 ? Integer.MIN_VALUE : nums2[partitionTwo-1];
            int secondMin = partitionTwo == len2 ? Integer.MAX_VALUE : nums2[partitionTwo];

            if(firstMax <= secondMin && secondMax <= firstMin){
                //found the center point
                if((len1+len2) % 2 == 0){
                    return (Math.max(firstMax, secondMax) + Math.min(firstMin, secondMin)) / 2.0;
                }
                else return (double) Math.max(firstMax, secondMax);
            }
            else if(firstMax > secondMin){
                high = partitionOne-1;
            }
            else{
                low  = partitionOne+1;
            }
        }
        return 0.0;
    }
}