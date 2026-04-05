class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        int ans = Integer.MIN_VALUE;
        for(int num: nums){
            int temp = curMax * num;
            curMax = Math.max(curMax*num, Math.max(num, num*curMin));
            curMin = Math.min(temp,       Math.min(num, num*curMin));
            ans = Math.max(ans, Math.max(curMax, curMin));
        }
        return ans;
    }
}