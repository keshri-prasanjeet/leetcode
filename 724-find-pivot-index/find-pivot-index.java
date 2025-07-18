class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftArr = new int[nums.length];
        int[] rightArr= new int[nums.length];
        leftArr[0] = nums[0];
        rightArr[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            leftArr[i] = leftArr[i-1]+nums[i];
        }

        for(int i=nums.length-2;i>=0;i--){
            rightArr[i] = rightArr[i+1]+nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(rightArr[i] == leftArr[i]) return i;
        }
        return -1;
    }
}