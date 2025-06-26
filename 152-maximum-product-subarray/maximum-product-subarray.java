class Solution {
    public int maxProduct(int[] nums) {
        int cMax = 1;
        int cMin = 1;
        int ans = Integer.MIN_VALUE;
        for(int num:nums){
            int temp = cMax * num;
            cMax = Math.max(cMax * num, Math.max(num, cMin * num));
            cMin = Math.min(temp, Math.min(num, cMin * num));
            ans = Math.max(ans, Math.max(cMin, cMax));
        }
        return ans;
    }
}