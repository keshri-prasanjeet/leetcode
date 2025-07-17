class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] subMap = new int[nums.length+1];
        int maxVal = 0;
        for(int i=nums.length;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] > nums[i]){
                    subMap[i] = Math.max(subMap[i], subMap[j] + 1);
                }
            }
            maxVal = Math.max(maxVal, subMap[i]);
        }
        return maxVal+1;
    }
}