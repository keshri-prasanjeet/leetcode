class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new ArrayList<>());
        return answer;
    }

    private void findCombination(int[] candidates, int target, int idx, List<Integer> combination){
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0) return;

        for(int i=idx;i<candidates.length;i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            findCombination(candidates, target-candidates[i], i+1, combination);
            combination.remove(combination.size()-1);
        }
    }
}