class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length-1;
        int i = m-1;
        int j = n-1;
        while(k>=0){
            if(i>=0 && j>=0){
                if(nums1[i]>=nums2[j]){
                    nums1[k--] = nums1[i--];
                }
                else{
                    nums1[k--] = nums2[j--];
                }
            }
            else if(i>=0){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        return;
    }
}