class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int first = i;
            int second = i+1;
            int third = len-1;
            while(second < third){
                int tSum = nums[first] + nums[second] + nums[third];
                if(tSum == 0){
                    answer.add(List.of(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    while(second < third && nums[second] == nums[second-1]) second++;
                    while(second < third && nums[third] == nums[third+1]) third--;
                }
                else if(tSum < 0){
                    second++;
                }
                else third--;
            }
        }
        return answer;
    }
}