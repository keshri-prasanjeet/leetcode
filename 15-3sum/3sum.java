class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int fixed = nums[i];
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right= len-1;
            while(left < right){
                int sum = fixed + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    answer.add(new ArrayList<>(List.of(fixed, nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return answer;
    }
}