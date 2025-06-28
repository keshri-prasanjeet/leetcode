class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int fixedNum = nums[i];
            int left = i+1;
            int right = len-1;
            while(left < right){
                int sum = fixedNum + nums[left] + nums[right];
                if(sum > 0) right--;
                else if (sum < 0) left++;
                else{
                    answer.add(new ArrayList<>(List.of(fixedNum, nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return answer;
    }
}