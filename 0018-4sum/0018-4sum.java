class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-3;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<len-2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = len-1;
                while(left < right){
                    long curSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(curSum > target){
                        right--;
                    }
                    else if(curSum < target){
                        left++;
                    }
                    else{
                        answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(right > left && nums[right] == nums[right+1]) right--;
                    }
                }
            }
        }
        return answer;
    }
}