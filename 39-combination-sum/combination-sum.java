class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        doCombination(candidates, target, combination, 0);
        return answer;
    }

    private void doCombination(int[] candidates, int target, List<Integer> combination, int startIndex){
        if(target < 0) return;
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            if(target-candidates[i] >= 0){
                combination.add(candidates[i]);
                doCombination(candidates, target - candidates[i], combination, i);
                combination.remove(combination.size()-1);
            }
        }
    }
}