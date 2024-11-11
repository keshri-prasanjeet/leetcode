class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        
        int res = nums[0];
        for(int num:nums){
            if(res<num) res = num;
        }

        for(int num:nums){

            int temp = curMax * num;
            curMax = Math.max(curMax * num, Math.max(curMin * num, num));
            curMin = Math.min(temp, Math.min(curMin * num, num));
            res = Math.max(res, curMax);
        }

        return res;
    }
}