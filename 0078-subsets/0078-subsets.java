class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        // [1,2,3]
        // [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
        // lets have an index that would keep track of where i am
        // new function witll have both array and the indes that we are trying to use to track.
        // if index == nums.length that means we have reached the end and then we can add this to the answer
        // we can then continue in the main part of the method that take, dont take

        int index = 0;
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubsets(nums, subset, index);
        return answer;
    }

    private void findSubsets(int[] nums, List<Integer> subset, int index){
        if(index == nums.length){
            //we are out of bounds
            answer.add(new ArrayList<>(subset));
            return;
        }
        //dont take
        findSubsets(nums, subset, index+1);
        //take
        subset.add(nums[index]);
        findSubsets(nums, subset, index+1);
        subset.remove(subset.size()-1);
        return;
    }
}