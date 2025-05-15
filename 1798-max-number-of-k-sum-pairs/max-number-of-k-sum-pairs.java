class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(nums[left] + nums[right] > k){
                right--;
            }
            else if(nums[left] + nums[right] < k){
                left++;
            }
            else{
                operations++;
                left++;
                right--;
            }
        }
        return operations;
    }
}