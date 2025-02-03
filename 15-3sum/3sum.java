class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int fixed = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int curSum = nums[left] + nums[right] + fixed;
                if(curSum == 0){
                    answer.add(new ArrayList<>(List.of(fixed, nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
                else if(curSum > 0){
                    right--;
                }
                else left++;
            }
        }
        return answer;
    }
}