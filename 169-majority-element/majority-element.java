class Solution {
    public int majorityElement(int[] nums) {
        int elem = nums[0];
        int power = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=elem){
                power--;
            }
            else power++;
            if(power==0){
                elem = nums[i];
                power = 1;
            }
        }
        return elem;
    }
}