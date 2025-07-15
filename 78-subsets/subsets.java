class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubsets(nums, subset, 0);
        return answer;
    }

    private void findSubsets(int[] nums, List<Integer> subset, int startIndex){
        //head first approach
        if(startIndex > nums.length) return;
        answer.add(new ArrayList<>(subset));
        for(int i=startIndex; i<nums.length;i++){
            if(i > startIndex && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            findSubsets(nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}