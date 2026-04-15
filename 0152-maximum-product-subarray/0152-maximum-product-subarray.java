class Solution {
    public int maxProduct(int[] nums) {
        int cMax = 1;
        int cMin = 1;
        int ans = Integer.MIN_VALUE;
        for(int num: nums){
            int temp = cMax * num;
            cMax = Math.max(num, Math.max(cMax*num, cMin*num));
            cMin = Math.min(num, Math.min(temp, cMin*num));
            ans = Math.max(ans, Math.max(cMax, cMin));
        }
        return ans;
    }
}