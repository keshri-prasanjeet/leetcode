class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1) return;
        int writeIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        while(writeIndex < nums.length){
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}