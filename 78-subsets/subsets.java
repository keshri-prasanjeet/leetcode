class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        doSubset(subset, 0, nums);
        return answer;
    }

    private void doSubset(List<Integer> subset, int index, int[] nums){
        answer.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            subset.add(nums[i]);
            doSubset(subset, i+1, nums);
            subset.remove(subset.size()-1);
        }
    }
}