class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, new ArrayList<>(), target, 0);
        return answer;
    }

    private void findCombinations(int[] candidates, List<Integer> combination, int target, int startIdx){
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0) return;
        for(int i=startIdx;i<candidates.length;i++){
            if(i>startIdx && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            findCombinations(candidates, combination, target - candidates[i], i+1);
            combination.remove(combination.size()-1);
        }
    }
}