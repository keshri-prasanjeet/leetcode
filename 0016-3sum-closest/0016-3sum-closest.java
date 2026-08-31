class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //need to find the 3sum closest to the target
        int len = nums.length;
        Arrays.sort(nums); //nLog(n)
        int closestDiff = Integer.MAX_VALUE;
        int closestNum = 0;
        for(int first = 0;first < len-2;first++){
            int second = first+1;
            int third = len-1;
            while(second < third){
                int tSum = nums[first] + nums[second] + nums[third];
                if(Math.abs(target-tSum) < closestDiff){
                    closestDiff = Math.abs(target-tSum);
                    closestNum = tSum;
                }
                if(tSum < target){
                    second++;
                }
                else{
                    third--;
                }
            }
        }
        return closestNum;
    }
}