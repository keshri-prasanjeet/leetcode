class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int lsq = nums[left] * nums[left];
            int rsq = nums[right] * nums[right];
            if(lsq >= rsq){
                result[i] = lsq;
                left++;
            }
            else {
                result[i] = rsq;
                right--;
            }
        }
        return result;
    }
}