class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 1) return;
        int nZ = 0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[nZ] = nums[i];
                nZ++;
            }
        }
        while(nZ < len){
            nums[nZ++] = 0;
        }
    }
}