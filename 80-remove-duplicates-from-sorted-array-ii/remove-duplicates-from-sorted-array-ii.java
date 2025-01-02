class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        boolean allowOnce = true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[index]){
                nums[index+1] = nums[i];
                index++;
                allowOnce = true;
            }
            else if(allowOnce == true){
                nums[index+1] = nums[i];
                index++;
                allowOnce = false;
            }
        }
        return index+1;
    }
}