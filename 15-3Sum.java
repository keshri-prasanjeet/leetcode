class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int fixed = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int curSum = fixed + nums[left] + nums[right];
                if(curSum==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(fixed);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    answers.add(triplet);
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
                else if(curSum > 0){
                    right--;
                }
                else left++;
            }
        }
        return answers;
    }
}