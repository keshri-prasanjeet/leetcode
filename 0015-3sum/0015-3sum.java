class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //lets try fixing first num + two pointers
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int first = nums[i];
            int j = i+1;
            int k = len-1;
            while(j < k){
                int tSum = first + nums[j] + nums[k];
                if(tSum == 0){
                    answer.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--; 
                }
                else if(tSum > 0){
                    k--;
                }
                else j++;
            }
        }
        return answer;
    }
}