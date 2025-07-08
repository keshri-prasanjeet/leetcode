class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombination(candidates, target, combination , 0);
        return answer;
    }

    private void findCombination(int[] candidates, int target, List<Integer> combination, int startIndex){
        if(target < 0) return;
        if(target == 0){
            answer.add(new ArrayList<>(combination));
        }
        for(int i=startIndex;i<candidates.length; i++){
            int num = candidates[i];
            combination.add(num);
            findCombination(candidates, target - num, combination, i);
            combination.remove(combination.size()-1);
        }
    }
}