class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[nums.length];
        int index = end;
        while(start<=end){
            if(squareVal(nums[start]) > squareVal(nums[end])){
                ans[index--] = squareVal(nums[start]);
                start++;
            }
            else{
                ans[index--] = squareVal(nums[end]);
                end--;
            }
        }
        return ans;
    }

    private int squareVal(int num){
        return num*num;
    }
}