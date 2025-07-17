class Solution {
    boolean ans = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        Arrays.sort(nums);
        int halfSum = sum/2;
        boolean[] targetMap = new boolean[halfSum+1];
        targetMap[0] = true;

        for(int num: nums){
            for(int j=halfSum;j>=num;j--){
                targetMap[j] = targetMap[j] || targetMap[j-num];
            }
        }
        return targetMap[halfSum];
    }
}