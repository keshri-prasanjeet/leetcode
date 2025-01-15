class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        boolean allowOnce = true;
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[i] && allowOnce == true){
                i++;
                nums[i] = nums[j];
                allowOnce = false;
            }
            else if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
                allowOnce = true;
            }
        }
        return i+1;
    }
}