class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(nums[i] <= first){
                first = nums[i];
                // second = Integer.MAX_VALUE;
                System.out.println(first);
            }
            else if(nums[i] > first && nums[i] <= second){
                second = nums[i];
                System.out.println(first+ " " + second);
            }
            else {
                System.out.println(first+ " " + second + " " + nums[i]);
                return true;
            }
        }
        return false;
    }
}