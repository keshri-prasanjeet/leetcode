class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedArray = new int[nums.length];
        int index = nums.length-1;
        int left = 0;
        int right = nums.length-1;
        while(index >=0 && left >=0 && right < nums.length && left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if(leftSq >= rightSq){
                sortedArray[index] = leftSq;
                left++;
            }
            else{
                sortedArray[index] = rightSq;
                right--;
            }
            index--;
        }
        return sortedArray;
    }
}