class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        doSubset(nums, subset, 0);
        return answer;
    }

    private void doSubset(int[] nums, List<Integer> subset, int index){
        if(index == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        doSubset(nums, subset, index+1);
        subset.remove(subset.size()-1);
        doSubset(nums, subset, index+1);
    }
}