class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, new ArrayList<>(), 0);
        return answer;
    }

    private void findCombinations(int[] candidates, int target, List<Integer> combination, int idx){
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0) return;
        for(int i=idx;i<candidates.length;i++){
            combination.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], combination, i);
            combination.remove(combination.size()-1);
        }
    }
}