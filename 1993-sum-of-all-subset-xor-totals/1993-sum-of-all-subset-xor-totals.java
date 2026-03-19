class Solution {
    int xorSum = 0;
    public int subsetXORSum(int[] nums) {
        doXor(nums, 0, 0);
        return xorSum;
    }

    private void doXor(int[] nums, int idx, int sum){
        if(idx == nums.length){
            xorSum += sum;
            return;
        }
        int newSum = sum ^ nums[idx];
        doXor(nums,idx+1,newSum);
        doXor(nums, idx+1, sum);
    }
}