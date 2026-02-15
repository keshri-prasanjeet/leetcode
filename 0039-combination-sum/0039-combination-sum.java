class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // since repetetion is allowed, i can take the current or skip
        // if the sum is equal to the target then add it to the answer list
        // if the sum has overshot then return 
        // if the sum is still less than the target sum then keep goin on/;
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombination(candidates, target, 0, combination);
        return answer;
    }

    private void findCombination(int[] candidates, int target, int index, List<Integer> combination){
        if(target < 0) return;
        if(0 == target){
            answer.add(new ArrayList<>(combination));
            return;
        }
        if(index == candidates.length) return;
        combination.add(candidates[index]);
        findCombination(candidates, target - candidates[index], index, combination);
        combination.remove(combination.size()-1);
        findCombination(candidates, target, index+1, combination);
    }
}