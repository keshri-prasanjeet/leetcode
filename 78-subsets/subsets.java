class Solution {
    int len;
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubsets(nums, 0, subset);
        return answer;
    }

    private void findSubsets(int[] nums, int index, List<Integer> subset){
        if(index == len){
            answer.add(new ArrayList<>(subset));
            return;
        }
        findSubsets(nums, index+1, subset);
        subset.add(nums[index]);
        findSubsets(nums,index+1, subset);
        subset.remove(subset.size()-1);
        
    }
}