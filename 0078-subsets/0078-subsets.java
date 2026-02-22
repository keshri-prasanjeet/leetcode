class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>());
        return answer;
    }

    private void findSubsets(int[] nums, int index, List<Integer> subset){
        if(index == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }
        //dont take
        findSubsets(nums, index+1, subset);
        //take
        subset.add(nums[index]);
        findSubsets(nums, index+1, subset);
        subset.remove(subset.size()-1);
    }
}