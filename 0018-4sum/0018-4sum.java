class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for(int first = 0;first < len-3;first++){
            if(first > 0 && nums[first] == nums[first-1]) continue;
            for(int second = first+1;second<len-2;second++){
                if(second > first+1 && nums[second] == nums[second-1]) continue;
                int third = second+1;
                int fourth = len-1;
                while(third < fourth){
                    long fourSome = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if(fourSome == target){
                        answer.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                        fourth--;
                        while(third < fourth && nums[third] == nums[third-1]) third++;
                        while(third < fourth && nums[fourth] == nums[fourth+1]) fourth--;
                    }
                    else if(fourSome < target){
                        third++;
                    }
                    else fourth--;
                }
            }
        }
        return answer;
    }
}