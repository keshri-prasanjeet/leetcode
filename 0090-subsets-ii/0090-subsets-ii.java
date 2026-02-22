class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, new ArrayList<>());
        return answer;
    }

    private void findSubsets(int[] nums, int index, List<Integer> subset){
        answer.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            findSubsets(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}