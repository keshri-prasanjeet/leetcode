class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int first = 0;
        int len = nums.length;
        int closestDiff = Integer.MAX_VALUE;
        int closestAns = Integer.MAX_VALUE;
        for(first=0; first < len-2; first++){
            int second = first+1;
            int third = len-1;
            while(second<third){
                int tSum = nums[first]+nums[second]+nums[third];
                if(Math.abs(target - tSum) < closestDiff) {
                    closestAns = tSum;
                    closestDiff = Math.abs((target - tSum));
                }
                if(tSum <= target){
                    second++;
                }
                else third--;
            }
        }
        return closestAns;
    }
}