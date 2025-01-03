class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int counter = 0;

        for(int i=0;i<nums.length;i++){
            if(counter == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                counter++;
            }
            else if(candidate != nums[i]){
                counter--;
            }
        }

        return candidate;
    }
}